package LeetCode;

import org.apache.coyote.OutputBuffer;

/**
 * @description: 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
 * https://www.jianshu.com/p/4ef3cfa01367
 * @author: zhanghailang
 * @date: 2021/2/25 0025 22:57
 */
public class LongestComStr {
    /**
     * 横向比较
     * @param strs
     * @return
     */
    public static String solution(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++){
            prefix = longestStr(prefix,strs[i]);
            if (prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }
    public static String longestStr (String str1,String str2){
        int length = Math.min(str1.length(),str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)){
            index ++;
        }
        return str1.substring(0,index);
    }


    /**
     * 纵向比较
     * Math.min
     * Math.max
     * @param strs
     */

    public static String solution2(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }

//        for (int i = 0; i < strs.length; i++){
//            for (int j = 0; j < strs[i].length(); j++){
//
//            }
//        }
        int pLength = strs[0].length();
        for (int i = 0; i < pLength; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++){
//                if (strs[j].charAt(i) != c){
//                    break;
//                }
                if (i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
//            return strs[0].substring(0,i);
        }
        return strs[0];
    }

    /**
     * 分治法
     * @param strs
     * @return
     */
    public static String solution3(String[] strs){
        if (strs == null || strs.length == 0){
            return "";
        }else {
            return longestCommonPrefix(strs,0,strs.length - 1);
        }
    }

    public static String longestCommonPrefix(String[] strs,int start,int end){
        if (start == end){
            return strs[start];
        } else {
            int mid = (end - start) / 2 + start;
            String lcpLeft = longestCommonPrefix(strs,start,mid);
            String lcpRight = longestCommonPrefix(strs,mid + 1,end);
            return commonPrefix(lcpLeft,lcpRight);
        }
    }

    public static String commonPrefix(String lcpLeft,String lcpRight){
        int minLength = Math.min(lcpLeft.length(),lcpRight.length());
        for (int i = 0; i < minLength; i++){
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)){
                return lcpLeft.substring(0,i);
            }
        }
        return lcpLeft.substring(0,minLength);
    }

    public static void main(String[] args) {
        String[] strs = {"abcde","abcdfe","abcrt"};
        System.out.println(solution(strs));
        System.out.println(solution2(strs));
        System.out.println(solution3(strs));
    }
}