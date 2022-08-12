package com.zhanghl.first.z220207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 最长回文字串
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"

 * @author: zhanghailang
 * @date: 2022/7/25 17:19
 */
public class LongestStr {
    //首先需要定义一下什么叫回文子串 什么叫动态规划
    public static String solution(String s) {
        return null;
    }
    // 算法 最优子结构 状态转移方程 重叠子问题
    // coins 中是可选硬币面值，amount 是目标金额
    int[] memo ;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -666);
        return dp3(coins, amount);
    }

    /**
     * 暴力递归 自顶向下 自底向上
     * dp数组 和dp函数的含义
     * @param coins
     * @param amount
     * @return
     */
    public int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (memo[amount] != -666) {
            return memo[amount];
        }

        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem == -1) continue;
            result = Math.min(result, subProblem + 1);
        }
        memo[amount] = result == Integer.MAX_VALUE ? -1 : result;
        return memo[amount];
    }

    public int dp2(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

//        int target = 0;
//        //思路不对吗 再次重来，专注一下 为什么需要这个循环 什么叫base case 最优子结构 什么叫状态转移方程

        int dp[] = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        //我该循环谁呀
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < amount; i ++) {
            for (int j = 0; j < coins.length; j ++) {
                if (dp[i] != 0) {
                    continue;
                }
                if (coins[j] == i) {
                    res = Math.min(res,dp[i] + 1);
                    dp[i] = res;
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 凑零钱 这个问题 首先进行分析的时候 分析它的最优子结构
     * 上来就最优子结构吗 问题的本质是 求能凑够 amount 的 硬币个数（无限） 上来先进行状态的确定吗
     * 状态
     * 选择
     * dp数组
     * @param coins
     * @param amount
     * @return
     */
    public int dp3(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        int[] dp = new int[amount] ;
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i < dp.length; i ++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];

    }
//
    public static void main(String[] args) {
        LongestStr str = new LongestStr();
        int[] coins = {1, 2, 4};
        System.out.println(str.coinChange(coins, 7));
    }


//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList();
//
//
//        list.add(11);
//        list.add(22);
//
//        LongestStr str = new LongestStr();
//        str.test1(list);
//        System.out.println(list.size());
//    }

    public void test1(List<Integer> list){
        List<Integer> list1 = new ArrayList<>();
        list1 = list.stream().filter(a -> a == 11).collect(Collectors.toList());
//        list.stream().forEach( a ->  {
//            System.out.println(a);
//        });
        list.add(33);

        System.out.println(list.size());
    }

    public int lengthOfLIS(int[] nums){
        
        return 0;
    }

}