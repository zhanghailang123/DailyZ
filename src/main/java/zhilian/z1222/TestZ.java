package zhilian.z1222;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/12/22 10:21
 */
@Slf4j
public class TestZ {

    public static void main(String[] args) {
        System.out.println(DateUtil.current(false));
        //are you right?
        try {
            throw new RuntimeException("test ex");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("erro：{}",e.getStackTrace());
        }
        //请求合并的本质 或者说关键点是 队列加定时任务 什么样的场景需要请求合并 对同一个热点账户 或者库存 整一个临时存储的队列 或者表 如果是单纯增加的命令事务应该不影响
        //如果是要减少原库存 那就有待商榷了 是指同一热点数据吗 可以指同一热点数据吗
        //如果是队列加定时任务 那其实也可以不理解成为请求合并 其实本质还是个异步处理一个变种操作吧
    }
}