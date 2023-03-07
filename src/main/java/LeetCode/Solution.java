package LeetCode;

import java.util.Arrays;
import java.util.List;

/**
 * @author hailang.zhang
 * @since 2023-02-17
 */
public class Solution {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 6, 3, 4, 5, 6);
        ListNode head = new ListNode(1);
        ListNode p = head;
        System.out.println(System.identityHashCode(head));
        System.out.println(System.identityHashCode(p));
        for (Integer item : list) {
            p.next = new ListNode(item);
            //为什么这一步对象没有指向同一个对象啊
            p = p.next;
            System.out.println(System.identityHashCode(p));
            System.out.println(System.identityHashCode(head));
        }
        Solution solution = new Solution();
        ListNode node = solution.removeElements(head, 6);
        System.out.println(node);
    }

    // 1->2 2 3 2 4 5
    // 1 2 3 4 5 666 777
    //   2 3 1 4 5 7777777 removeElements(head,val) ddidiid
    public ListNode removeElements(ListNode head, int val) {
        //        while (head != null && head.val == val) {
        //            head = head.next;
        //        }
        //        if (head == null) {
        //            return head;
        //        }
        //        //那我们就再来一次呗
        //
        //        while (head.next != null) {
        //            if (head.next.val == val) {
        //                head.next = head.next.next;
        //            } else {
        //                head = head.next;
        //            }
        //            head.next = head.next.next;
        //        }
        //        return head;
        //
        while (head != null && head.val == val) {
            head = head.next;
        }
        // 已经为null，提前退出
        if (head == null) {
            return head;
        }
        // 已确定当前head.val != val
        //方案一 虚拟头节点处理 方案二 直接转换本身
        //我的处理是head本身来做 有什么输入和输出的
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
//                pre.next = cur.next;
                cur.next = cur.next.next;
            } else {
//                pre = cur;
                cur.next = cur.next.next;
            }

        }
        return head;
    }
}

class ListNode {

    int val;

    ListNode next;

    ListNode() {}

    ListNode(int val) {this.val = val;}

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}