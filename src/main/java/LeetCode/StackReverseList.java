package LeetCode;


import java.util.Arrays;
import java.util.Stack;

/**
 * @description: 栈的解法
 * @author: zhanghailang
 * @date: 2020-12-16 11:18
 */
public class StackReverseList {

    public static Node ReverseList(Node node){
        Stack<Node> stack = new Stack<>();
        //将链表节点全部摘掉放到栈中
        while (node != null){
            stack.push(node);
            node = node.next;
        }
        Node pop = stack.pop();
        Node result = pop;
        while (!stack.empty()){
//            Node temp = stack.pop();
//            pop.next = temp;
            pop.next = stack.pop();
            pop = pop.next;
        }
        pop.next = null;

        return result;


    }

    static class Node{
        private int val;
        private Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * 实例化一个链表
     * @param array
     * @return
     */
    private static Node buildNodeList(int[] array){
        Node head = new Node(array[0]);
        Node p = head;
        for (int i = 1; i < array.length; i++){
            p.next = new Node(array[i]);
            p = p.next;

            System.out.println(head);
            System.out.println(p);
        }
        return head;
    }

    public static void main(String[] args) {
//        int[] temp = {2,5,8,3};
//        Node node = buildNodeList(temp);
//        while (node != null){
//            Node mNode = node.next;
//            node.next = null;
//        }
//        Node result = ReverseList(node);
//        while (result != null){
//            System.out.println(result.val);
//            result = result.next;
//        }
        User11 user = new User11();
        user.setUsername("张三");
        user.setAge(22);
        User11 lisi;
        lisi = user;
        user.setAge(25);
        user.setUsername("ksdjakj;djk;a");

        lisi.setUsername("李四");
        User12 user12 = new User12();
        user12.setUsername("里面的名字呀");
        lisi.setUser12(user12);


        System.out.println(user);
        System.out.println(lisi);


        int[] arrays = {1,2,3};
        StackReverseList.buildNodeList(arrays);
    }
}