package LeetCode;

/**
 * @description: dg
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/3chong-jie-jue-fang-shi-zhan-shuang-lian-biao-di-2/
 * @author: zhanghailang
 * @date: 2020-12-16 9:44
 */
public class DiGuiReverseList {
    public static class Node{
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    private static Node initNodeList(int[] arrays){
        //基本数据类型和引用数据类型 此处给rNode 赋值  赋值一个引用
        //node 也指向了这个引用
        //node 把这个引用给修改了
        //导致 rNode这个引用也是改变了
        Node rNode = new Node(arrays[0]);
        Node node = rNode;
        for (int i = 1; i < arrays.length; i ++){
            node.next = new Node(arrays[i]);
            node = node.next;
        }
        return rNode;
    }
    //makemoney moneymaker makemoney moneymaker
    public static Node reverseList(Node node){
        //终止条件
        if(node == null || node.next == null){
            return node;
        }
        // 1 2 3 4
        //逻辑处理
        //保存当前节点的下一节点
        Node temp = node.next;
        //2 3 4
        //3 4
        //4
        //递归调用
        //从当前节点的下一节点开始递归调用
        Node reverse = reverseList(temp);
        //node 挂在 temp节点后面就可以了 完成了反转
        temp.next = node;
        node.next = null;
        return reverse;
    }

    /**
     * 再来一遍
     * @param node
     */
    public static Node reverseList2(Node node){
        // 1-2-3-4-5  5-4-3-2-1
        if (node == null || node.next == null){
            return node;
        }
        Node mi = node.next;
        reverseList2(mi);

        Node temp = node.next;
        Node result = node;
        result.next = temp;
        return result;
    }

    /**
     * 递归调用之后head.next节点会成为reverse节点的尾节点
     * @param node
     */
    public static Node reverseList3(Node node){
        if (node == null ||  node.next == null){
            return node;
        }
        // 5 4 3 2 1
        Node result = reverseList3(node.next);
        node.next.next = node;
        node.next = null;
        return result;
    }

    /**
     * 尾递归
     * @param node
     * @return
     */
    public static Node reverseList4(Node node){
        return new Node(1);
    }
    public static void main(String[] args) {
        int[] array = {1,3,9,7,0};
        Node node = initNodeList(array);
//        while (node != null){
//            System.out.println(node.val);
//            node = node.next;
//        }
        Node result = reverseList3(node);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}