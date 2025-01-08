package swordtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二叉树前序遍历成为链表
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhanghailang
 * @date: 2021/6/22 0022 22:03
 */
public class TreeNodeToList {
     class TreeNode {
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
//    TreeNode re = new TreeNode(root.val);
    public void solution(TreeNode root){
//         List<Integer> list = new ArrayList<>();
//
//         while (root.left != null || root.right != null){
//
//         }
        if (root == null){
            return ;
        }
    }

    /**
     * 迭代
     * @param root
     */
    public void solution1(TreeNode root){
        List<TreeNode> list = new ArrayList<>();
        preFill(root,list);
        for (int i = 1; i < list.size(); i ++){
            TreeNode curr = list.get(i);
            TreeNode pre = list.get(i-1);
            pre.left = null;
            pre.right = curr;

        }
    }
    public void preFill(TreeNode root,List<TreeNode> list){
        if (root != null){
            list.add(root);
            preFill(root.left,list);
            preFill(root.right,list);
        }
    }
}