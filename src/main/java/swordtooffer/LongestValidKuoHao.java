package swordtooffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 最长的有效括号
 * ()(())
 * @author: zhanghailang
 * @date: 2021-6-5 20:20
 */
public class LongestValidKuoHao {
    /**
     * 动态规划思想 开始想
     * 冷静集中专注努力
     * 财富自由之路
     * @param s
     * @return
     */
    public int solution(String s){
        int n = s.length();
        if (n <= 1){
            return 0;
        }
        //使用DP数组表示第i位下标 为最长有效长度的大小
        int[] dp = new int[n];
        int res = 0;
        for (int i = 1; i < n; i++){
            Character ch = s.charAt(i);
            if (")".equals(String.valueOf(ch))){
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + 1;
            }
        }
        return 0;
    }


    /**
     * 使用栈Stack来巧解这一题
     * @param s
     * @return
     */
    public int solution2(String s){
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i)=='('){
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                } else {
                    res = Math.max(res,i - stack.peek());
                }
            }

        }
        return res;
    }

    /**
     * 双指针 最简单可以理解的方式
     * ((())()))
     * @param s
     * @return
     */
    public static int solution3(String s){
        int left = 0,right = 0,res = 0;
        for (int i = 0; i < s.length(); i++ ){
            if (s.charAt(i) == '('){
                left ++;
            } else {
                right ++;
            }
            if (left != 0 && left == right){
                res = Math.max(res,2*left);
            } else if (right > left){
                left = right = 0;
            }
        }
        for (int i = s.length() -1; i >= 0; i--){
            if (s.charAt(i) == '('){
                left ++;
            } else {
                right ++;
            }
            if (left != 0 && left == right){
                res = Math.max(res,2*left);
            } else if (left > right){
                left = right = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution3("((())()))"));
    }
}