package swordtooffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树前序遍历
 * @author: zhanghailang
 * @date: 2021-5-28 16:48
 */
public class PreSortTree {
    List<Integer> re = new ArrayList<>();

    /**
     * 传统递归
     * @param root
     * @return
     */
    //第一要素明确你这个函数要干什么
    public List<Integer> preSort(TreeNode root){
        //第二要素：寻找递归结束的条件
        if (root == null){
            return re;
        }
        //第三要素，找出函数的等价关系式
        re.add(root.val);
        if (root.left != null){
            preSort(root.left);
        }
        if (root.right != null){
            preSort(root.right);
        }
        return re;
    }

    public List<Integer> preSort1(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()){
            while (treeNode != null){
                re.add(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            if (!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(5);
        TreeNode root = new TreeNode(3,left,right);
        PreSortTree sort = new PreSortTree();
//        System.out.println(sort.preSort(root));
        System.out.println(sort.preSort1(root));
    }
}