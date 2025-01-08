package LeetCode;


import java.util.HashMap;

/**
 * @description: leetcode上部分关于滑动窗口解法的题目
 * @author: zhanghailang
 * @date: 2021/2/4 0004 22:11
 */
public class SlipWindow {
    /**
     * LeetCode #209
     * 长度最小的子数组
     * 题目描述：
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     * 示例:
     * 输入：s = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     */
    public static int minLenOfArray(int[] array,int s){
        /**
         * 自己写的暴力法 有点小问题
         */
        int re = 100;
        for (int i = 0; i < array.length; i ++){
            for (int j = i; j < array.length; j++){
                if (array[i] + array[j] >= s){
                    re = j - i;
                    return Math.min(re,j-i+1);
                }
            }
        }
        return re;
    }

    public static int minLenOfArray1(int[] array,int s){
        /**
         * 修复后的暴力法
         */
        //初始化子数组长度为数组长度+1
        int result = array.length + 1;
        for (int i = 0; i < array.length; i ++){
            int sum = 0;
            for (int j = i; j < array.length; j++){
                sum += array[j];
                if (sum >= s){
                    //如果当前累加和大于正整数，则更新子数组长度
                    result = Math.min(result,j - i + 1);
                }
            }
        }
        //如果最终result的值等于数组长度+1，则表示不存在符合条件的子数组
        return result == array.length + 1 ? 0 : result;
    }

    /**
     * 双指针
     * @param array
     * @param s
     * @return
     */
    public static int minLenOfArray2(int[] array,int s){
        if (array.length == 0){
            return 0;
        }
        int left  = 0;
        int right = 0;
        int sum = 0 ;
        int re = array.length + 1;
        while (sum < s) {
            if (right <= array.length){
                right = right + 1;
                sum += array[right];
            }
        }
        return 1;
    }

    public static int minLenOfArray3(int[] array,int s){
        if (array.length == 0){
            return 0;
        }
        int left = 0;
        int right = -1;
        int sum = 0;
        int re = array.length + 1;
        while (left < array.length){
            if (right + 1 < array.length && sum < s){
                right ++;
                sum += array[right];

            }else {
                sum -= array[left];
                left ++;
            }
            if (sum >= s){
//                re = right - left + 1;
//                return re == array.length + 1 ? 0 : re;
                re = Math.min(re,right - left + 1);
            }
        }
        return re == array.length + 1 ? 0 : re;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        HashMap hashMap = new HashMap(16);
        System.out.println(minLenOfArray(nums,6));
        System.out.println(minLenOfArray1(nums,6));
        System.out.println(minLenOfArray3(nums,7));
    }
}