package com.zhanghl.first.retry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/4/17 0017 22:48
 */
public class RetryTest {
    public static void main(String[] args) {
        RetryTest test = new RetryTest();
        test.findAnagrams("cbaebabacd", "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        //关键点是 如何 判断 是全部包含了p 对不对 三个
        HashMap<Character, Integer> need  = new HashMap<Character, Integer>();
        HashMap<Character, Integer> cache = new HashMap<Character, Integer>();
        for (Character c : p.toCharArray()) {
            need.put(c, 1);
        }

        List<Integer> result = new ArrayList<Integer>();

        int left = 0; int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (need.containsKey(c)) {
                cache.put(c, cache.getOrDefault(c, 0) + 1);
            }
            right++;
            //什么时候开始移动左边界
            while (right - left >= p.length()) {
                char d = s.charAt(left);
                if (cache.size() == need.size()) {
                    result.add(left);
                    cache.clear();
                }
                left ++;
            }
        }

        return result;
    }
}