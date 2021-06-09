package LeetCode;

import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 对于动态规划算法的理解
 * @author: zhanghailang
 * @date: 2021-5-12 14:58
 */
public class ThinkDP {
    /**
     * 描述：leetcode原题：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 10 级的台阶总共有多少种跳法。
     */

    /**
     * 传统解法
     * @param n
     * @return
     */
    public static int solution1(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return solution1(n-1) + solution1(n-2);
    }

    /**
     * 备忘录式解法
     * 避免重复计算问题
     * 张海浪 你是真的菜 还没脑子啊
     * @param n
     * @return
     */
    static Map inMap = new HashMap();
    public static int dpSolution(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        //为什么要用数组，在这个地方我没了思路。
        //备忘录怎么存储？？？
        if (inMap.containsKey(n)){
            return (int) inMap.get(n);
        }
        inMap.put(n,dpSolution(n-1) + dpSolution(n-2));
        return (int) inMap.get(n);
    }


    /**
     * 动态规划式解法。
     * 自底向上，
     * 最优子结构，
     * 状态转移方程。
     * 边界
     * 重叠子问题
     * @param n
     * @return
     */
    public static int dpSolution1(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
//        int dp[] = new int[n];  疯了 芽儿呦 为啥是这样子的计算呢
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++ ){
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }
    public static void main(String[] args) {
        System.out.println(dpSolution(10));
        System.out.println(dpSolution1(10));
    }
}