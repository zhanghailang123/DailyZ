package com.zhanghl.first.z220207;

import java.util.*;

/**
 * @description: 快速排序
 * @author: zhanghailang
 * @date: 2022/7/15 13:34
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] nums = {3,2,4};
        Arrays.stream(QuickSort2.twoSum(nums, 6)).forEach(a -> System.out.println(a));
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            cache.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (cache.get(target - nums[i]) != null ) {
                return new int[] {cache.get(target - nums[i]), i};
            }
        }
        return new int[0];
    }

}