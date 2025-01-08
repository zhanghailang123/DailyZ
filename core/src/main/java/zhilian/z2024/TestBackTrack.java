package zhilian.z2024;

/**
 * @author hailang.zhang
 * @since 2024-04-10
 */
public class TestBackTrack {

    private int res = 0;
    int temp = 0;
    public int combinationSum4(int[] nums, int target) {
        // int[] dp = new int[target +1];
        // dp[0] = 1;

        // for(int i = 0; i <=target; i ++) {
        //     for(int j = 0; j < nums.length;j++) {
        //         if(i >= nums[j]) {
        //             dp[i] = dp[i] + dp[i-nums[j]];
        //         }
        //     }
        // }
        // return dp[target];

        backTrack(nums, 0, target);
        return res;
    }

    private void backTrack(int nums[], int sum, int target) {
        //终止条件是什么？
        temp = sum;
        if(temp >= target) {
            if(temp == target) {
                res ++;
                temp = 0;
            }
            return;
        }

        for(int i = 0; i < nums.length; i ++) {
            System.out.println(sum);
            sum += nums[i];
            backTrack(nums, sum, target);
            sum = sum - nums[i];
        }
    }

    public static void main(String[] args) {
        TestBackTrack testBackTrack = new TestBackTrack();
        int[] nums = {4,3,1};
        int target = 10;
        int count = testBackTrack.combinationSum4(nums, target);
        System.out.println("最终结果:  " + count);
    }
}