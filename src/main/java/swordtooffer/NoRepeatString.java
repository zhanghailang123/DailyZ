package swordtooffer;

/**
 * @description: 无重复字符的最长子串
 *
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。



示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author: zhanghailang
 * @date: 2021-6-18 11:24
 */
public class NoRepeatString {
    public static int solution1(String s){
        int n = s.length();
        int res = 0;
        int L = 0, R = 1;
        for (int i = 0; i < n; i ++){
            while (i >= 1 && (s.charAt(R) != s.charAt(i))){
                R++;
            }
//            while (i >= 1 && (s.charAt(R) == s.charAt(i))){
//
//            }
            res = Math.max(res,R - i + 1);

        }
        return res;
    }


    public static int solution2(String s){

    }

    public static void main(String[] args) {
        System.out.println(solution1("abcabcbb"));
    }
}