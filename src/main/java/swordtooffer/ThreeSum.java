package swordtooffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 三数之和
 * @author: zhanghailang
 * @date: 2021-6-17 11:09
 */
public class ThreeSum {
    public List<List<Integer>> solution(int nums[]){
        int n = nums.length;
        //三个数之和为0
        //先算出其他两数的和 可能会重复啊
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i ++){
            if (nums[i] > 0) return lists;
            if (i > 0 && nums[i] == nums[i-1]) continue;;
            int curr = nums[i];
            int L = i + 1;
            int R = n - 1;
            while (L < R){
                int tmp = curr + nums[L] + nums[R];
                if (tmp == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    lists.add(list);
                    while (L < R && nums[L+1] == nums[L])
                        ++L;
                    while (L < R && nums[R-1] == nums[R])
                        --R;
                    ++L;
                    --R;
                } else if(tmp < 0){
                    ++L;
                } else {
                    --R;
                }
            }
        }
        return lists;
    }

    public List<List<Integer>> solution1(int[] nums){
        int n = nums.length;
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i ++){
            int L = i + 1;
            int R = n - 1;
//            int calRe = L? + i + R;
            while (L < R){
                int calRe = L + R + i;
                if (calRe == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[R]);
                    list.add(nums[L]);
                    lists.add(list);
                    while (L < R & nums[L] == nums[L+1]) L++;
                    while (L < R & nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                } else if (calRe < 0){
                    L++;
                } else {
                    R--;
                }

            }
        }
        return lists;
    }
}