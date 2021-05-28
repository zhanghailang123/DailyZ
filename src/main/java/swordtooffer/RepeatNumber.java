package swordtooffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: 剑指Offer第一题
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-b-4/
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 示例 1：
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhanghailang
 * @date: 2021-5-27 21:52
 */
public class RepeatNumber {
    /**
     * 太简单没什么好说的
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        Map map = new HashMap();
        int n = nums.length;
        for(int i = 0; i < n; i ++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            } else {
                return nums[i];
            }
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums){
        Set set = new HashSet<>();
        for (int num : nums){
            if (!set.add(nums)){
                return num;
            }
        }
        return -1;
    }
}