package com.zhanghl.first.aaa;

/**
 * @description: 前k个高频元素
 * https://leetcode.cn/problems/top-k-frequent-elements/
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * O（nlogn）
 * @author: zhanghailang
 * @date: 2022/7/1 9:40
 */
public class TopK {

    public static int[] result(int[] nums, int k) {
        //1.快速排序加去重？
        //2.优先级队列
//        int length = nums.length;
//
//        int mid = (length + 1) / 2;
//        for (int i = 0; i < length; i ++) {
//
//        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = result(nums, k);
        System.out.println(result);
    }
}