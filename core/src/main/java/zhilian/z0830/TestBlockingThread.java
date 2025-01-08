package zhilian.z0830;

import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/9/16 16:24
 */
@Slf4j
public class TestBlockingThread {

    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    i++;
                    if (i != 0) {
                        boolean b = 1 % i == 0;

//                        try {
//                            Thread.sleep(0);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
                    }
                }
            }
        };
        new Thread(new logTimer()).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(r).start();

    }

    private static class logTimer implements Runnable{

        @Override
        public void run() {
            while (true) {
                long currentTimeMillis = System.currentTimeMillis();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("zhltime: " + (System.currentTimeMillis() - currentTimeMillis));

            }
        }
    }
}