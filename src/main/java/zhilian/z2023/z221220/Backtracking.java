package zhilian.z2023.z221220;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zhanghailang
 * @since 2022/12/20 12:06
 **/
public class Backtracking {
    List<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        this.backTracking(nums, path, used);
        return result;
    }

    public void backTracking(int[] nums, LinkedList<Integer> path, boolean[] used) {
        if (path.size() == nums.length) {
            result.add(new LinkedList<>(path));
//            result.add(path);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backTracking(nums,path,used);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Backtracking backtracking = new Backtracking();
        List<List<Integer>> permute = backtracking.permute(nums);
        System.out.println(permute);
    }
}
