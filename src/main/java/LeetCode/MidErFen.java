package LeetCode;


/**
 * @description: 从二分查找法  说到冒泡排序
 * @author: zhanghailang
 * @date: 2021-5-19 13:17
 */
public class  MidErFen {
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
     * deep known
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

    public static int erFen2(int[] nums,int target){
        int n = nums.length - 1;
        int left = 0;
        int right = n;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else if (nums[mid] == target){
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
//        System.out.println(1/2);
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println(erFen2(nums,5));
    }

    /**
     * 测试写着玩的
     * @param nums
     * @param target
     * @return
     */
    public int erFenT(int[] nums,int target){
        int left = 0;
        int right = nums.length;
        return -1;
    }

    public int digui(int left,int right,int[]nums,int target){
        int mid = (right - left) / 2;
        if (nums[mid] == target){
            return mid;
        }
        int a = digui(left,mid,nums,target);
        int b = digui(mid,right,nums,target);
        if (a >= 0 || b >= 0 ){
            return a >= 0 ? a : b;
        }
        return -1;
    }
}