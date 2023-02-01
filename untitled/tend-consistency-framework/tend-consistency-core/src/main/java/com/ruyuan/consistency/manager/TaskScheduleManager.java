package com.ruyuan.consistency.manager;

import com.ruyuan.consistency.exceptions.ConsistencyException;
import com.ruyuan.consistency.model.ConsistencyTaskInstance;
import com.ruyuan.consistency.service.TaskStoreService;
import com.ruyuan.consistency.utils.ReflectTools;
import com.ruyuan.consistency.utils.SpringUtil;
import com.ruyuan.consistency.utils.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * 任务调度管理器
 *
 * 儒猿课堂: http://www.ruyuan2020.com
 * @Author zhonghuashishan
 * @Remark 有问题直接联系客服VX: ruyuan-1111 ，源码-笔记-技术交流群
 * @Version 1.0
 **/
@Slf4j
@Component
public class TaskScheduleManager {

    /**
     * 任务存储mapper组件
     */
    @Autowired
    private TaskStoreService taskStoreService;
    /**
     * 并行任务线程池
     */
    @Autowired
    private CompletionService<ConsistencyTaskInstance> consistencyTaskPool;

    @Resource
    private TaskEngineExecutor taskEngineExecutor;

    /**
     * 该方法在业务服务中的定时任务中进行调度
     * 查询并执行未完成的一致性任务
     */
    public void performanceTask() throws InterruptedException {
        List<ConsistencyTaskInstance> consistencyTaskInstances = taskStoreService.listByUnFinishTask();
        if (CollectionUtils.isEmpty(consistencyTaskInstances)) {
            return;
        }
        // 过滤出需要被执行的任务
        consistencyTaskInstances = consistencyTaskInstances.stream()
                .filter(e -> e.getExecuteTime() - System.currentTimeMillis() <= 0)
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(consistencyTaskInstances)) {
            return;
        }

        CountDownLatch latch = new CountDownLatch(consistencyTaskInstances.size());
        for (ConsistencyTaskInstance instance : consistencyTaskInstances) {
            consistencyTaskPool.submit(() -> {
                try {
                    // 执行任务
                    taskEngineExecutor.executeTaskInstance(instance);
                    return instance;
                } finally {
                    latch.countDown();
                }
            });
        }
        latch.await();
        log.info("[一致性任务框架] 执行完成");
    }

    /**
     * 执行指定任务
     *
     * @param taskInstance 任务实例信息
     */
    public void performanceTask(ConsistencyTaskInstance taskInstance) {
        // 获取方法签名 格式：类路径#方法名(参数1的类型,参数2的类型,...参数N的类型)
        String methodSignName = taskInstance.getMethodSignName();
        // 获取方法所在的类
        Class<?> clazz = getTaskMethodClass(methodSignName.split("#")[0]);
        if (ObjectUtils.isEmpty(clazz)) {
            return;
        }
        Object bean = SpringUtil.getBean(clazz);
        if (ObjectUtils.isEmpty(bean)) {
            return;
        }
        // 后面把methodName独立出一个字段
        String methodName = taskInstance.getMethodName();
        // 获取参数类型的字符串字符串 多个用逗号分隔
        String[] parameterTypes = taskInstance.getParameterTypes().split(",");
        // 构造参数类数组
        Class<?>[] parameterClasses = ReflectTools.buildTypeClassArray(parameterTypes);
        // 获取目标方法
        Method targetMethod = getTargetMethod(methodName, parameterClasses, clazz);
        if (ObjectUtils.isEmpty(targetMethod)) {
            return;
        }
        // 构造方法入参
        Object[] args = ReflectTools.buildArgs(taskInstance.getTaskParameter(), parameterClasses);
        try {
            // 执行目标方法调用
            ThreadLocalUtil.setFlag(true);
            targetMethod.invoke(bean, args);
            ThreadLocalUtil.setFlag(false);
        } catch (InvocationTargetException e) {
            log.error("调用目标方法时，发生异常", e);
            Throwable target = e.getTargetException();
            throw new ConsistencyException((Exception) target);
        } catch (Exception ex) {
            throw new ConsistencyException(ex);
        }
    }

    /**
     * 获取目标方法
     *
     * @param methodName              方法名称
     * @param parameterTypeClassArray 入参类数组
     * @param clazz                   方法所在类的Class对象
     * @return 目标方法
     */
    private Method getTargetMethod(String methodName, Class<?>[] parameterTypeClassArray, Class<?> clazz) {
        try {
            return clazz.getMethod(methodName, parameterTypeClassArray);
        } catch (NoSuchMethodException e) {
            log.error("获取目标方法失败", e);
            return null;
        }
    }

    /**
     * 构造任务方法所在的类对象
     *
     * @param className 类名称
     * @return 类对象
     */
    private Class<?> getTaskMethodClass(String className) {
        Class<?> clazz;
        try {
            clazz = Class.forName(className);
            return clazz;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
