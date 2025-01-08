package swordtooffer;

/**
 * @description: 二叉树定义
 * @author: zhanghailang
 * @date: 2021-5-28 16:49
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}