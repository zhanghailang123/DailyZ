package zhilian.z2023.z221220;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/12/29 15:31
 */
public class Window1 {

    public List<Integer> findAnagrams(String s, String p) {
        int left = 0, right = 0, valid = 0;
        List<Integer> answer = new ArrayList<Integer>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> cache = new HashMap<>();

        for(int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //我需要使用滑动窗口的思想 back
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            //进行判断逻辑
            if (need.containsKey(c)) {
                cache.put(c, cache.getOrDefault(c, 0) + 1);
                if (cache.get(c).equals(need.get(c))) {
                    valid ++;
                }
            }

            //come to this time enjoy your work and life
            while (right - left == p.length()) {
                if (valid == need.size()) {
                    answer.add(left);
                }
                char d = s.charAt(left);
                left ++;

                if (need.containsKey(d)) {
                    if (cache.get(d).equals(need.get(d))) {
                        valid --;
                    }
                    cache.put(d, cache.getOrDefault(d, 0) - 1);
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        Window1 window1 = new Window1();
        System.out.println(window1.findAnagrams("baa", "aa"));
    }
}