package LeetCode;

/**
 * @description: https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * 最长连续递增序列
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhanghailang
 * @date: 2021-5-17 20:56
 */
public class LengthOfLCIS {

    /**
     * 我的暴力解法
     * @param nums
     * @return
     */
    private static int max = Integer.MAX_VALUE;
    public static int solution1(int[] nums){
        int re = 1;
        for (int i = 1; i < nums.length; i ++){
            if (nums[i] > nums[i-1]){
                 re ++;
            } else {
                continue;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,5,6,4,7};
        System.out.println(solution1(nums));
    }
}