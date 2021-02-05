package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: LeetCode438
 * @author: zhanghailang
 * @date: 2021-2-5 14:12
 */
public class SlipWindow2 {
    /**
     * LeetCode #438
     * 找到字符串中所有字母异位词
     * 题目描述：
     * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     * 说明：
     * 字母异位词指字母相同，但排列不同的字符串。
     * 不考虑答案输出的顺序。
     *
     *
     * 示例:
     * 输入: s: "cbaebabacd" p: "abc"
     * 输出: [0, 6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     */

    public int[] SimpleZM(String s, String p){
        if (s.length() < 0){
            throw new RuntimeException("字符串不能为空");
        }

        return null;
    }

    public List<Integer> simpleZM(String s, String p){
        List<Integer> resultList = new ArrayList<>();
        //计算p中各元素出现的次数
        int[] pFreq = new int[26];
        for (int i = 0; i < p.length(); i ++){
            pFreq[p.charAt(i) -'a'] ++;
        }

        int start = 0, end = -1;
        while (start < s.length()){
            //还有剩余元素未考察，且窗口内字符串长度小于p的长度
            //则扩大窗口右边边界
            if (end + 1 < s.length() && end - start + 1 < p.length()){
                end ++;
            }else {
                //右侧不能继续扩大或者窗口内字符串长度小于字符串p的长度
                start ++;
            }
            //当窗口内字符串长度等于字符串p的长度时，则判断其是不是字符串p的字母异位词子串
            if (end - start + 1 == p.length() && isSimpleStr(s.substring(start,end + 1),pFreq)){
                resultList.add(start);
            }
        }
        return resultList;
    }

    private boolean isSimpleStr(String window,int[] pFreq){
        //计算窗口内字符串各元素的出现次数
        int[] windowFreq = new int[26];
        for (int i = 0; i < window.length(); i ++){
            windowFreq[window.charAt(i) - 'a'] ++;
        }
        //比较窗口内各元素的出现次数和字符串p中各元素出现的次数是否一样
        //如果都一样。则说明窗口内字符串是字符串的异位词子串
        //如果不一样 则说明不是子串
        for (int j= 0; j < 26; j ++){
            if (windowFreq[j] != pFreq[j]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "abcda";
        for (int i = 0; i < s.length(); i ++){
            System.out.println(s.charAt(i) - 'a');
        }
    }
}