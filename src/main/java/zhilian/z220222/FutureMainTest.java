package zhilian.z220222;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/2/23 0023 22:48
 */
public class FutureMainTest {

    public static void main(String[] args) throws InterruptedException {
        ScoreQueryService service = new ScoreQueryService();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 1; i++) {
            executorService.execute(() -> {
                Integer re = null;
                try {
                    re = service.query("ZHL");
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("分数：" + re);
            });
        }
        TimeUnit.SECONDS.sleep(1);
        for (Map.Entry<String, Future<Integer>> stringFutureEntry : ScoreQueryService.SCORE_CACHE.entrySet()) {
            stringFutureEntry.getValue().cancel(true);
        }
    }
}