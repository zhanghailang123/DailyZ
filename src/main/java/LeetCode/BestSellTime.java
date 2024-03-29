package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * LeetCode 121
 * 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。


 * @author: zhanghailang
 * @date: 2021-3-2 16:43
 */
public class BestSellTime {
    /**
     * 理解有点问题 此方法多了个参数 让题目变得容易了 -_- -_- -_- -_-
     * @param nums
     * @param day
     * @return
     */
    public static int solution(int[] nums,int day){
        //边界值处理有问题
//        if (nums == null ||nums.length == 0){
//            return 0;
//        }
        if (nums.length < 2){
            return 0;
        }
        int re = 0;
        for (int i = day - 1; i < nums.length; i++){
//            if (nums[i+1] > nums[i] && i+1 <nums.length){
//            System.out.println(nums[i]);
                re = Math.max(re,nums[i]-nums[day-1]);
//            }
        }
        return re;
    }

    /**
     * 暴力解法的准确解法  上面方法签名都整错了
     * @param nums
     * @return
     */
    public static int solution1(int[] nums){
        int len = nums.length;
        if (len < 2){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++){
                res = Math.max(res,nums[j] - nums[i]);
            }
        }
        return res;
    }

    /**
     * 动态规划的写法分析 dp数组
     * @param nums
     * @return
     */
    public static int dpSolution(int[] nums){
        int len = nums.length;
        if (len < 2){
            return 0;
        }
        int[][] dp = new int[len][2];
        //dp[i][0]下标为i，这天结束时，不持股，手上拥有的现金数     ????为什么是现金数 假如按照持股数来说会有问题嘛 focus
        //dp[i][1]下表为i，这天结束时，持股，手上拥有的现金数
        //初始化 不持股显然为0，持股显然就需要减去第1天（下标为0）的股价
        dp[0][0] = 0;
        dp[0][1] = -nums[0];
        //从第二天开始遍历
        for (int i = 1 ;i < len; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + nums[i]);
            dp[i][1] = Math.max(dp[i-1][1],-nums[i]);
        }
        return dp[len-1][0];
    }

    /**
     * 只想循环一次 不想循环两次
     * 使用空间复杂度来换取时间复杂度的优化
     * 牛牛牛 这个方法可以
     * @param nums
     * @return
     */
    public static int dpSolution1(int[] nums){
        int n = nums.length;
        if (n < 2){
            return 0;
        }
        int minPrice = Integer.MAX_VALUE;
        int res = 0;
        //[7,1,5,3,6,4]  [1,2]
        for (int i = 0; i < nums.length; i ++){
            minPrice = Math.min(minPrice,nums[i]);
            if (i == 0){
                res = 0;
            }
            else if(nums[i] > nums[i-1]){
                res = Math.max(res,nums[i] - minPrice);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,2};
//        System.out.println(solution(nums,2));
//        System.out.println(solution1(nums));
        System.out.println(dpSolution1(nums));

        Map map = new HashMap(2);
        map.put("1","1");
        map.put("2","1");
        map.put("3","1");
        map.put("4","1");
        map.put("5","1");
        map.put("6","1");
        map.put("7","1");
        map.put("8","1");
        map.get(1);
        System.out.println((4 - 1) & 51);
        ReentrantLock lock = new ReentrantLock();
        String s = "We are happy.";
        String re = s.replaceAll(" ","%20");
        System.out.println(re);
        Stack stack = new Stack();
        stack.peek();
//        LinkedList
    }
}