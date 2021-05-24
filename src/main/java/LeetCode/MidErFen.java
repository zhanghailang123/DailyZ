package LeetCode;

import jdk.nashorn.internal.ir.IfNode;

/**
 * @description: 从二分查找法  说到冒泡排序
 * @author: zhanghailang
 * @date: 2021-5-19 13:17
 */
public class MidErFen {
    public static int erFen(int[] nums,int target){

        int left = 0;
        int right = nums.length - 1;
        return  erFen(left,right,nums,target);
    }

    public static int erFen(int left, int right,int[] nums,int target){
        int mid = (right-left) / 2;
        if (nums[mid] == target){
            return mid;
        }
        if (mid == 0 || (nums[mid] != target && mid == 1)){
            throw new RuntimeException("二分查找法未查找到目标值");
        }
        int b = erFen(left,mid,nums,target);
        int a = erFen(mid,right,nums,target);

        if (a >= 0 || b >=0){
            return a >= 0 ? a : b;
        }
        if (mid == 0){
            throw new RuntimeException("二分查找法未查找到目标值");
        }
        return -1;
    }

    /**
     * correct solution
     * @param nums
     * @param target
     * @return
     */
    public static int erFen1(int[] nums,int target){
        int min = 0;
        int max = nums.length - 1;
        while (min <= max){
            int mid = min + (max - min) / 2;
            if (nums[mid] > target){
                max = mid - 1;
            } else if (nums[mid] < target){
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
//        System.out.println(1/2);
//        int[] nums = {1,2,3,4,5,6};
//        System.out.println(erFen(nums,1));
        int a = Integer.MAX_VALUE;
        System.out.println(a);
    }
}