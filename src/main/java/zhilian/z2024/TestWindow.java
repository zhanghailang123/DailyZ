package zhilian.z2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hailang.zhang
 * @since 2024-03-30
 */
public class TestWindow {


    /**
     * 求字符串 s 中包含字符串 t 所有字符的最小子串
     * @param s 源字符串
     * @param t 给定字符串
     * @return 满足条件的最小子串
     */
    public static String minWindow(String s, String t) {
        int len = s.length();

        HashMap<Character, Integer> targets = new HashMap<>();
        for(char d : t.toCharArray()) {
            targets.put(d, targets.getOrDefault(d, 0) + 1);
        }

        HashMap<Character, Integer> cache = new HashMap<>();
        int left = 0, right = 0;
        int min = 0, max = 0;
        int res = Integer.MAX_VALUE;
        String ss = "";
        int valid = 0;
        while(right < len) {
            Character c = s.charAt(right);
            right ++ ;


            if(targets.containsKey(c)){
                cache.put(c, cache.getOrDefault(c, 0) + 1);
                if(cache.getOrDefault(c, 0).equals(targets.get(c))) {
                    valid ++;
                }
            }


            System.out.println(left + " ===" + right);
            while(valid == targets.size()) {
                if(right - left < res) {
                    res = right -left;
                    ss = s.substring(left, right);
                }

                char e = s.charAt(left);

                left ++;
                if(targets.containsKey(e)) {
                    if(cache.getOrDefault(e, 0).equals(targets.get(e))) {
                        valid --;
                    }
                    cache.put(e, cache.getOrDefault(e, 0) - 1);
                }
            }



            System.out.println(left + "每次循环 ===" + right);

        }
        return ss;
    }
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

}