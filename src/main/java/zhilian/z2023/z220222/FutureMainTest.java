package zhilian.z2023.z220222;

import java.util.concurrent.*;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/2/23 0023 22:48
 */
public class FutureMainTest {

    public static void main(String[] args) throws InterruptedException {
        ScoreQueryService service = new ScoreQueryService();
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                Integer re = null;
                try {
                    re = service.query("ZHL");
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("分数：" + re);
            });
        }
        Thread.sleep(5000);
        executorService.execute(() -> {
            System.out.println("又一次查询开始");
            try {
                service.query("ZHL");
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
//        TimeUnit.SECONDS.sleep(1);
//        for (Map.Entry<String, Future<Integer>> stringFutureEntry : ScoreQueryService.SCORE_CACHE.entrySet()) {
//            stringFutureEntry.getValue().cancel(true);
//        }
    }
}