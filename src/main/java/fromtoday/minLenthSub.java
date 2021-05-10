package fromtoday;

/**
 * @description: 大于等于指定某个数的最小连续子数组
 * @author: zhanghailang
 * @date: 2020/12/16 0016 22:08
 */
public class minLenthSub {
    //方法一 暴力破解法
    public int getResult(int[] nums,int s){
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i ++){
            int sum = 0;
            for (int j = i; j < n; j ++){
                sum += nums[j];
                if (sum >= s){
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    //方法二 双指针 或者说是滑动窗口
    public static int getResultByWindow(int[] nums, int s){
        int n = nums.length;
        if (n == 0){
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;
        while (right < n){
            sum += nums[right];
            while (sum >= s){
                ans = Math.min(ans,right - left + 1);
                sum -= nums[left];
                left ++ ;
            }
            right ++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    // calm,careful,study
    //临界点 需要转换的问题
    public int minLen(int[] arr,int s){
        int start = 0;
        int end = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (end <= arr.length){
            //不能这么直接加
//            sum += arr[end] + arr[start];
            sum += arr[end];
            while (sum >= s){
                //这步里面的顺序和逻辑是怎么样的？
//                res = start - end;
                res = Math.min(res,end -start + 1);
                sum -= arr[start];
                start ++;

            }
            end ++;

        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
    public static void main(String[] args) {
        int[] arrays = {1,2,2,1,4,5,6,2};
        System.out.println(getResultByWindow(arrays,10));
    }
}