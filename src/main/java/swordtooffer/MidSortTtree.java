package swordtooffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 中序遍历  左 中 右
 * @author: zhanghailang
 * @date: 2021-5-31 9:46
 */
public class MidSortTtree {
    List<Integer> re = new ArrayList<>();

    private List<Integer> midSort(TreeNode root){
        if (root == null){
            return re;
        }
        if (root.left != null){
            midSort(root.left);
        }

        re.add(root.val);
        if (root.right != null){
            midSort(root.right);
        }

        return re;
    }

    /**
     * 中序遍历 左 中 右
     * @param root
     * @return
     */
    private List<Integer> midSort2(TreeNode root){
        //冷静 集中 专注 努力
        //冷静 集中 专注 努力
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty() ){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            re.add(curr.val);
            curr = curr.right;
        }
        return re;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(5);
        TreeNode root = new TreeNode(3,left,right);
        MidSortTtree midSortTtree = new MidSortTtree();
        System.out.println(midSortTtree.midSort2(root));
    }
}