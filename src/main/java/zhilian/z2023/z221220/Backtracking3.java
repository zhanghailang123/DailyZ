package zhilian.z2023.z221220;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2022/12/21 10:14
 */
public class Backtracking3 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<Integer>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        tracking(candidates, target, path, 0);
        return result;
    }

    public void tracking(int[] candidates, int target, LinkedList<Integer> path, int startIndex) {
        int sum = 0;
        for (int i : path) {
            sum += i;
        }
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            tracking(candidates, target, path, i);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};

        Backtracking3 backtracking3 = new Backtracking3();
        System.out.println(backtracking3.combinationSum(nums, 7));
    }
}