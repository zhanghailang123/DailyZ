package fromtoday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: 回溯法 计算 abc的排列问题
 * @author: zhanghailang
 * @date: 2020/10/9 0009 23:15
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Permutation("abc".toString()));
    }

    public ArrayList<String> Permutation(String str){
        List<String>  res = new ArrayList<String>();
        if (str != null && str.length() > 0){
            PermutationHelper(str.toCharArray(),0,res);
            Collections.sort(res);
        }
        return (ArrayList<String>) res;
    }

    public void PermutationHelper(char[] cs, int i, List<String> list){
        if (i == cs.length - 1){
            String val = String.valueOf(cs);
            if(!list.contains(val)){
                list.add(val);
            }
        } else{
            for (int j = i ;j < cs.length; j++){
                swap(cs,i,j);
                PermutationHelper(cs, i+1, list);
                swap(cs,i,j);
            }
        }
    }
    public  void swap(char[] cs, int i, int j ){
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}