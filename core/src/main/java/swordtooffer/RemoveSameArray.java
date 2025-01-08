package swordtooffer;

/**
 * @description:
 * 给定一个排序数组，删除重复元素
 * 双指针你都没理解 扯个蛋蛋啊
 * @author: zhanghailang
 * @date: 2021-6-4 15:28
 */
public class RemoveSameArray {
    public static int removeSame(int[] nums){
        int n = nums.length;
        int left = 0,right = 1;
        while (right < n){
            if (nums[left] != nums[right]){
                left ++;
                nums[left] = nums[right];
            }
            right ++;
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4,4,5,6,6,6};
        int re = removeSame(nums);
        System.out.println(re + "==================");
        System.out.println(nums);
    }
}