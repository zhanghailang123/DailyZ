package com.zhanghl.first.reduceif;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DPSolution {

    /**
     * 最长子序列
     *
     * @param nums
     * @return
     */
    public static int lenthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i ++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i ++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        System.out.println(DPSolution.lenthOfLIS(nums));

        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
