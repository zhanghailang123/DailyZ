package main.java.zhilian.z2024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hailang.zhang
 * @since 2024-04-10
 */
public class TestBackTrack2 {

    //找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
    private List<List<Integer>> result = new LinkedList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(k,n,0,1);
        return result;
    }

    // make some mistakes

    /**
     * 1.收集结果 不能用sum
     * 2.里层横向遍历时的值
     * 3.sum赋值问题
     * @param k
     * @param n
     * @param sum
     * @param startIndex
     */
    private void backTrack(int k, int n, int sum, int startIndex) {
        if(path.size() == k) {
            if(sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for(int i = startIndex; i <= 9; i ++) {
            path.add(i);
            sum = sum + i;
            backTrack(k,n,sum, i+1);
            path.removeLast();
            sum = sum - i;
        }
    }

    public static void main(String[] args) {
        TestBackTrack2 testBackTrack2 = new TestBackTrack2();
        List<List<Integer>> lists = testBackTrack2.combinationSum3(3, 9);
        System.out.println(lists);
    }
}