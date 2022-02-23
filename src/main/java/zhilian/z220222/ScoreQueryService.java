package zhilian.z220222;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @description: https://mp.weixin.qq.com/s/bnItRL-z-Pak8Diup3lZGw
 * Future 是个伪异步
 * @author: zhanghailang
 * @date: 2022/2/22 0022 21:48
 */
public class ScoreQueryService {

    private final Map<String,Integer> SCORE_CACHE = new HashMap<>();

    public Integer query(String userName) {
        Integer result = SCORE_CACHE.get(userName);
        if (result == null) {
            result = loadFromDB(userName);
            SCORE_CACHE.put(userName,result);
        }
        return result;
    }

    public synchronized Integer loadFromDB(String userName) {
        System.out.println("开始查询：" + userName + "的分数");
        //模拟耗时
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextInt(380,420);
    }

    public static void main(String[] args) {
//        Future
//        FutureTask
        ScoreQueryService service = new ScoreQueryService();
//        Integer score = service.query("张三");
//        System.out.println("张三score = " + score);
//        Integer score2 = service.query("张三");
//        System.out.println("张三score = " + score2);

        //开始变形
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                Integer zy = service.loadFromDB("zy");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("zy = " + zy);
            });
        }
    }
}