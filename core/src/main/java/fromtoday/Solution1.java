package fromtoday;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: two  sum  算法
 * @author: zhanghailang
 * @date: 2020/9/21 0021 22:31
 */
public class Solution1 {

    //暴力法
    public int[] twoSum(int[] nums,int target){
        for (int i = 0; i < nums.length; i ++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == target - nums[j]){
                    return  new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    //两遍hash表



    //一遍hash表

    public  int[] twoSum2(int[] nums,int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++){
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}