package swordtooffer;


import java.util.*;

/**
 * @description: 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/jian-dan-bfsdfs-bi-xu-miao-dong-by-sweetiee/
 * @author: zhanghailang
 * @date: 2021-5-31 13:53
 */
public class RightVersionTree {
    /**
     * 辣鸡 不用看
     * @param root
     * @return
     */
    public static List<Integer> getRightVersion(TreeNode root){
        List<Integer> re = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode curr = root;
//        while (curr != null && !stack.isEmpty()){
//            while (curr != null){
//                stack.push(curr);
//                curr = curr.right;
//            }
//            curr = stack.pop();
//            re.add(curr.right.val);
//            curr = curr.left;
//        }
        if (root == null){
            return re;
        }
        if (root.right != null){
            re.add(root.val);
            getRightVersion(root.right);
        } else {
            getRightVersion(root.left);
        }
        return re;

    }

    /**
     * 深度优先搜索算法的思想 DFS
     * 1.每一层选中的是1个
     * 2.第一次放进去的肯定是最右边的那一个
     * 3.保证最先取到的是右子树
     * @return
     */
    public static List<Integer> depthSearch(TreeNode root){
        Map<Integer,Integer> reMap = new HashMap<>();
        int max_depth = -1;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);
        while (!nodeStack.isEmpty()){
            TreeNode node =  nodeStack.pop();
            int depth = depthStack.pop();
            if (node != null){
                max_depth = Math.max(max_depth,depth);
            }
            if (!reMap.containsKey(depth)){
                reMap.put(depth,node.val);
            }
            nodeStack.push(node.left);
            nodeStack.push(node.right);
            depthStack.push(depth + 1);
            depthStack.push(depth + 1);
        }
        List<Integer> reList = new ArrayList<>();
        for (int i = 0; i < max_depth; i++){
            reList.add(reMap.get(i));
        }
        return reList;
    }

    /**
     * 广度优先搜索算法 BFS
     * @param root
     * @return
     */
    public static List<Integer> broudSearch(TreeNode root){
        List<Integer> re = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
                if (i == size - 1){
                    re.add(node.val);
                }
            }
        }
        return re;
    }
    static List<Integer> re = new ArrayList<>();
    public static List<Integer> depthSearch2(TreeNode root){

        dfs(root,0);
        return re;
    }
    private static void dfs(TreeNode root, int depth){
        if (root == null){
            return;
        }
        if (depth == re.size()){
            re.add(root.val);
        }
        depth ++;
        dfs(root.right,depth);
        dfs(root.left,depth);
    }
}