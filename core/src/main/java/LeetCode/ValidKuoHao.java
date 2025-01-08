package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description: 有效的括号  https://leetcode-cn.com/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。

 * @author: zhanghailang
 * @date: 2021-5-10 11:18
 */
public class ValidKuoHao {
    public static Boolean solution(String s){
//        String a1 = "(";
//        String a2 = ")";
//        String b1 = "{";
//        String b2 = "}";
//        String c1 = "[";
//        String c2 = "]";
        Map<Character,Character> paMap = new HashMap<>(4);
        paMap.put('(',')');
        paMap.put('{','}');
        paMap.put('[',']');
        if (s.length() % 2 != 0){
            return false;
        }
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            System.out.println("输出字符"+ch);
            if (paMap.containsKey(ch)){
                stack.push(ch);
            } else {
                if (stack.isEmpty() || ch != paMap.get(stack.peek())){
//                    System.out.println(stack.peek());
//                    System.out.println(paMap.get(stack.peek()));

                    return false;
                }
                stack.pop();

            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Boolean re = solution("((");
        System.out.println(re);
    }
}