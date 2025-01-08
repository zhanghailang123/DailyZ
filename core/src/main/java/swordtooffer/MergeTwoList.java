package swordtooffer;

import org.w3c.dom.Node;

import java.util.List;

/**
 * @description: 合并两个递增排序的链表
 *
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 * @author: zhanghailang
 * @date: 2021-6-16 17:21
 */
public class MergeTwoList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode solution(ListNode l1,ListNode l2){
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

    public ListNode solution2(ListNode l1,ListNode l2){
        ListNode temp = new ListNode(0),cur = temp;
        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return temp.next;
    }
}