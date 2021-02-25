package LeetCode;

/**
 * @description: 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
 * https://www.jianshu.com/p/4ef3cfa01367
 * @author: zhanghailang
 * @date: 2021/2/25 0025 22:57
 */
public class LongestComStr {
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
}