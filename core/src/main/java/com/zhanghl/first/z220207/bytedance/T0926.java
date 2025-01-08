package com.zhanghl.first.z220207.bytedance;

import java.util.Arrays;

/**
 * @description: 完整的先过一下labuladong的动态规划小抄
 * @author: zhanghailang
 * @date: 2022/9/26 17:11
 */
public class T0926 {

    /**
     * tell you first user baolidigui
     * kk you failed you lost
     * this time you dont nedd to win but you dont want lost dont wantr to be a loser
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        //start write specific funstions mean dont move  budabei aya maya
        // this is
        int[] dp = new int[amount];
        Arrays.fill(dp, -100);
        /**
         * Base case
         */
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int re = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (dp[amount -coins[i]] >= 0) {
                re = Math.min(re, dp[amount -coins[i]] + 1);
                continue;
            }
            int subProblem = coinChange(coins, amount - coins[i]);
            dp[amount -coins[i]] = subProblem + 1;
            if (subProblem == -1) {
                continue;
            }
            re = Math.min(re, subProblem + 1);
            //not it focus on it ya
            // give me five
            //actually you have done something
//           re = Math.min(coinChange(coins, amount -coins[i]), re);
        }
        return re == Integer.MAX_VALUE ? -1 : re;
    }
    //需要使用备忘录shi的解法
    //这个备忘录放在哪儿 作用肯定是不想for 循环这么多次
//    public static int coinChange1(int[]coins, int amount) {
//        int[] dp = new int[amount];
//
//    }
//
//    public int dp(int[]coins, int amount) {
//
//    }

    //cou ling qian baolidigui
    int[] cache;
    public int coinChange3(int[]coins, int amount) {
        cache = new int[amount];
        Arrays.fill(cache, -888);
        return dp(coins, amount);
    }

    public int dp(int[]coins, int amount) {

        if (cache[amount] != -888) {
            return cache[amount];
        }

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (dp(coins,amount -coin) < 0) {
                continue;
            }
            res = Math.min(res, dp(coins,amount -coin));
        }
        cache[amount] = (res == Integer.MAX_VALUE ? -1 : res + 1);
        return res == Integer.MAX_VALUE ? -1 : res + 1;
    }

    /**
     * dp函数聚焦的是含函数返回值 dp数组的索引
     * is this a dp thinking ? because it looks like so easy? or call it not difficult
     *
     * 另一种暴力递归呗
     * dp[i] = min(dp[i-coin])
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange4(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        //where is base case
        //dpp[1] dpp[2]
        dp[0] = 0;
        for (int i = 0; i <= amount; i ++) {
            for (int coin : coins) {
                //--back java 19 loom项目 kotlin 协程 swift 协程  go 协程 c++ 就差java的虚拟线程了 千呼万唤始出来
                //now im in knowledge sea enjoy every leaf
                if (i -coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        return dp[amount] >= amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
//        T0926.coinChange4(new int[] {1,2,5}, 11);
        T0926.coinChange4(new int[] {2}, 3);
    }
}