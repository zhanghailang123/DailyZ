package LeetCode;

import java.util.Arrays;

/**
 * @description: 凑零钱问题 ---动态规划
 * 凑够指定钱数的硬币的数量
 * https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 * @author: zhanghailang
 * @date: 2021-3-4 20:16
 */
public class GetAmount {
    public static int coinChange(int[] coins,int amount){
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        //为什么在这里把dp数组的每一项用 金额+1 给填满
        //dp数组中元素为所需硬币的个数  dp[i] 为amount 金额的大小 dp[0] = 0 怎么理解呢
        //if coins[j] < = i
        //{1,2,3,4,5,9} ,100
        Arrays.fill(dp,max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++){
                if (coins[j] <= i){
                    dp[i] = Math.min(dp[i],dp[i - coins[j]] +1 );
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }



    public static int coinChange1(int[] coins,int amount){
        return 0;
    }
    public static void main(String[] args) {
        int[] coins = {1,2,3,4,5,9};
        System.out.println(coinChange(coins,100));
    }
}