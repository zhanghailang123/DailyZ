package fromtoday;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 不含有重复字符的最长子串
 * @author: zhanghailang
 * @date: 2020/12/15 0015 22:50
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class ReapteString {
    public int lengthOfLongest(String s){
        //哈希集合，记录每个字符是否出现过
        Set<Character> occ= new HashSet<>();
        int n = s.length();
        //右指针 ，初始值为 -1，相当于我们在字符串左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i){
            if (i != 0){
                //左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i -1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))){
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans,rk - i + 1);
        }
        return ans;
    }
}