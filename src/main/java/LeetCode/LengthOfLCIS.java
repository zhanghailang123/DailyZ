package LeetCode;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 动态规划的解法
     * 动态规划的思想是连续的，也就是说上一个状态和下一个状态之间是有关系且联系的
     * 状态转移方程
     *
     * @param nums
     * @return
     */
    public static int solution2(int[] nums){
        int n = nums.length;
        if (n == 0 || n == 1){
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        int res = 0;
        for (int i = 1; i < n; i++){
            if (nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,2,3,5,6,4,7};
        System.out.println(solution1(nums));
        System.out.println(solution2(nums));
        lengthOfLongestSubstring("pwwkew");
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        int left = 0, right = 0,res = 0;
        while(right < n){
            if(!map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),right);
                res = Math.max(res,right - left + 1);

            }   else {
                map.put(s.charAt(right),right);
                left = Math.max(map.get(s.charAt(right)) + 1,left);
                res = Math.max(res,right - left + 1);
            }
            // if(map.containsKey(s.charAt(right))){
            //     left = Math.max(left,map.get(s.charAt(right)) + 1);
            // }
            // map.put(s.charAt(right),right);
            res = Math.max(res,right - left + 1);
            right ++;
        }
        return res;



//         if (s.length()==0) return 0;
//         HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//         int max = 0;
//         int left = 0;
//         for(int i = 0; i < s.length(); i ++){
//             if(map.containsKey(s.charAt(i))){
//                 left = Math.max(left,map.get(s.charAt(i)) + 1);
//             }
//             map.put(s.charAt(i),i);
//             max = Math.max(max,i-left+1);
//         }
//         return max;

    }
}