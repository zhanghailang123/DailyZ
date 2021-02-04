package Web;

import java.util.Stack;

/**
 * @description: 环形链表
 * @author: zhanghailang
 * @date: 2020/10/10 0010 23:11
 */
public class CycleList {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
            next = null;
        }
    }

    /**
     * 双链表法反转链表
     * @param args
     */
    private ListNode reverseList(ListNode head){
        ListNode newhead = null;
        while(head != null){
            //先保存访问节点的下一个节点，留着下一步访问用的
            ListNode temp = head.next;
            //每次访问的原链表的节点都会成为新链表的头结点
            head.next = newhead;
            //更新新链表
            newhead = head;
            //重新赋值，继续访问
            head = temp;

        }
        return newhead;
    }



////    public ListNode detectCycle(ListNode head){
////        Stack
////    }
//public static void main(String[] args) {
//    ListNode listNode = new ListNode(3);
//    listNode.next = new ListNode(4);
//    listNode.next.next = new ListNode(5);
//    listNode.next.next.next = new ListNode(6);


//}
}