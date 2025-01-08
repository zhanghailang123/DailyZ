package Web;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/2/26 0023 22:48
 */
public class FutureMainTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScoreQueryService service = new ScoreQueryService();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 3; i++) {
            Future<Integer> result = executorService.submit(() -> {
//                try {
//                    Integer re = service.query("ZHL" + new Random().nextInt(100));
//                    System.out.println("分数：" + re);
//                    return re;
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (TimeoutException e) {
//                    e.printStackTrace();
//                }
                Callable callable = () -> {
                    while (!Thread.currentThread().isInterrupted()) {
//                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(1+1);
                        if (1 + 1 != 2 ) {
                            break;
                        }
                    }
//                    TimeUnit.SECONDS.sleep(10);
                    return "11111";
                };
                FutureTask<Integer> future = new FutureTask<Integer>(callable);
                future.run();
                return null;
            });
            try {
                System.out.println(result.get(1, TimeUnit.SECONDS));
            } catch (TimeoutException e) {
                System.out.println("已超时");
                System.out.println("取消结果" + result.cancel(true));
            }

        }
//        CompletableFuture.runAsync().
//        TimeUnit.SECONDS.sleep(1);
//        for (Map.Entry<String, Future<Integer>> stringFutureEntry : ScoreQueryService.SCORE_CACHE.entrySet()) {
//            stringFutureEntry.getValue().cancel(true);
//        }
    }
}