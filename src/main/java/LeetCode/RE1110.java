package LeetCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/11/10 9:54
 */
public class RE1110 {

    @Autowired
    private RedisTemplate redisTemplate;

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 2) {
            return n;
        }

        int left = 0, res = 0;

        Map<Character, Integer> map = new HashMap<>();
        //滑动窗口 不断右移 无重复的最长子串
//        for (int i = 0; i < n; i++) {
//
//            if (!map.containsKey(s.charAt(i))) {
//                res = Math.max(res, i - left + 1);
//                map.put(s.charAt(i), i);
//            } else if (left <= i) {
//                for (Map.Entry<Character, Integer> entry : map.entrySet()
//                ) {
//                    left = Math.max(left, map.get(s.charAt(i)));
//                }
//
//            }
//
//        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left,map.get(s.charAt(i)) +1);
            } else {
                res = Math.max(res, i-left+1);
            }
            map.put(s.charAt(i),i);
        }
        return res;
    }

    public static void main(String[] args) {
//        redisTemplate.opsForZSet().add()
        int i = RE1110.lengthOfLongestSubstring("pwwkew");
        System.out.println(i);
    }
}