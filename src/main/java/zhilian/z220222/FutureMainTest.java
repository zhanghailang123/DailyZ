package zhilian.z220222;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/2/23 0023 22:48
 */
public class FutureMainTest {

    public static void main(String[] args) {
        ScoreQueryService service = new ScoreQueryService();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
               Integer re =  service.query("ZHL");
                System.out.println("分数：" + re);
            });
        }
    }
}