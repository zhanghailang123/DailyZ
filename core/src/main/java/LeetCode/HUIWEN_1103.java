package LeetCode;

/**
 * @description: 回文
 * @author: zhanghailang
 * @date: 2022/11/3 9:39
 */
public class HUIWEN_1103 {
    public static void main(String[] args) {
        String s = "aaaaaaa";
//        int len = s.length();
//        boolean dp[][] = new boolean[len][len];
//
//        int maxLen = 0, maxL = 0, maxR = 0;
//
//        for (int r = 1; r < len; r++) {
//            for (int l = 0; l < r; l++) {
//                if ((dp[l+1][r-1] || (r - l == 1))&& s.charAt(l) == s.charAt(r)) {
//                    dp[l][r] = true;
//                    if (r - l + 1 > maxLen ) {
//                        maxLen = r - l + 1;
//                        maxL = l;
//                        maxR = r;
//                    }
//                }
//            }
//        }
        if (s == null || s.length() < 2) {
//            return s;
        }
        int strLen = s.length();
        int maxStart = 0;
        int maxEnd = 0; //最长回文串的终点
        int maxLen = 1;
        boolean[][] dp = new boolean[strLen][strLen];
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        new Thread(() -> {
            while (true) {
                try {
                    System.out.println("循环唤醒");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (HUIWEN_1103.class) {
                    HUIWEN_1103.class.notifyAll();
                }
            }
        }).start();
        synchronized (HUIWEN_1103.class) {
            try {
                System.out.println("要开始等待了");
                HUIWEN_1103.class.wait(10000);
                System.out.println("等待结束了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        HUIWEN_1103.class.notifyAll();



        System.out.println(s.substring(maxStart, maxEnd + 1));
    }
}