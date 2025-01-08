package zhilian.z2023.z220222;

import cn.hutool.core.util.StrUtil;

import javax.validation.constraints.Email;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/2/22 0022 21:48
 */
public class ScoreQueryService {

    public static final Map<String,Future<Integer>> SCORE_CACHE = new ConcurrentHashMap<>();

//    public Integer query(String userName) throws ExecutionException, InterruptedException {
////        Future<Integer> result = SCORE_CACHE.get(userName);
////        if (result == null) {
////            Thread.sleep(5000);
////            Callable<Integer> callable = () -> this.loadFromDB(userName);
////            FutureTask futureTask = new FutureTask(callable);
////            result = futureTask;
////            futureTask.run();
////            SCORE_CACHE.putIfAbsent(userName,futureTask);
////        }
////        return result.get();
//        while (true) {
//        Future<Integer> future = SCORE_CACHE.get(userName);
//        if (future == null) {
//            Callable<Integer> callable = () -> loadFromDB(userName);
//            FutureTask futureTask = new FutureTask<>(callable);
//            future = SCORE_CACHE.putIfAbsent(userName, futureTask);
//            if (future == null) {
//                future = futureTask;
//                futureTask.run();
//            }
//        }
////            System.out.println(SCORE_CACHE.size() + " :  剩余任务数");
//        try {
//            Integer re = future.get();
//            System.out.println("ttttttttt" + re);
//            return re;
//        } catch (CancellationException e) {
//            System.out.println("查询userName = " + userName + " 的任务被移除");
////            SCORE_CACHE.remove(userName, future);
//        } catch (Exception e) {
//            throw e;
//        }
//
//        }
//    }
//
//    public Integer loadFromDB(String userName) throws InterruptedException {
//        System.out.println("开始查询：" + userName + "的分数");
//        //模拟耗时
//        TimeUnit.SECONDS.sleep(3);
//
//        return ThreadLocalRandom.current().nextInt(380,420);
//    }
//
////    public static void main(String[] args) {
//////        Future
//////        FutureTask
////        ScoreQueryService service = new ScoreQueryService();
//////        Integer score = service.query("张三");
//////        System.out.println("张三score = " + score);
//////        Integer score2 = service.query("张三");
//////        System.out.println("张三score = " + score2);
////
////        //开始变形
////        ExecutorService executorService = Executors.newFixedThreadPool(5);
////        for (int i = 0; i < 3; i++) {
////            executorService.execute(() -> {
////                Integer zy = service.loadFromDB("zy");
////                try {
////                    Thread.sleep(1000);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////                System.out.println("zy = " + zy);
////            });
////        }
////    }

    public Integer query(String userName) throws Exception {
        while (true) {
            Future<Integer> future = SCORE_CACHE.get(userName);
            if (future == null) {
                Callable<Integer> callable = () -> loadFormDB(userName);
                FutureTask futureTask = new FutureTask<>(callable);
                future = SCORE_CACHE.putIfAbsent(userName, futureTask);
                //如果为空说明之前这个 key 在 map 里面不存在
                if (future == null) {
                    future = futureTask;
                    futureTask.run();
                }
            }
            try {
                return future.get();
            } catch (CancellationException e) {
                System.out.println("查询userName=" + userName + "的任务被移除");
                SCORE_CACHE.remove(userName, future);
            } catch (ExecutionException e) {
                throw e;
//                throw launderThrow
            }
        }
    }

    private Integer loadFormDB(String userName) throws ExecutionException, InterruptedException {
        System.out.println("开始查询userName=" + userName + "的分数");
        //模拟耗时
        int i = 1/0;
        TimeUnit.SECONDS.sleep(5);
        return ThreadLocalRandom.current().nextInt(380, 420);
    }
}