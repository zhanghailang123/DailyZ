package com.zhanghl.first.z220207.bytedance;

import java.util.HashMap;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/9/23 9:59
 */
public class T0923 {

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        HashMap<Character, Integer> cache = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            //focus focus zhunazhu focus
            if (!cache.containsKey(s.charAt(i))) {
                cache.put(s.charAt(i), i);

            } else {
                left  = i;
            }
            max = Math.max(max, i - left + 1);

        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}