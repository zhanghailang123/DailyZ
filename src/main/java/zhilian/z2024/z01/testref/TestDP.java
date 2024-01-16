package zhilian.z2024.z01.testref;

/**
 * @author hailang.zhang
 * @since 2024-01-12
 */
public class TestDP {

    public int solution(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1 ; i < nums.length; i ++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[nums.length-1];
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        TestDP testDP = new TestDP();
        int[] nums = {4,10,4,3,8,9};
        int result = testDP.solution(nums);
        System.out.println(result);
    }
}