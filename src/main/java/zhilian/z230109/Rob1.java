package zhilian.z230109;

import java.util.Arrays;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2023/1/10 9:36
 */
public class Rob1 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,0);
        //dp[i] = dp[i-1]
        //dp[i] = dp[i-2] + nums[i]
        //its all your fault
        int res = Math.max(nums[0],nums[1]);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        for (int i = 2;  i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Rob1 rob1 = new Rob1();
        System.out.println(rob1.rob(nums));
    }
}