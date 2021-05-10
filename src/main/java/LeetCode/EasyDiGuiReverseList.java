package LeetCode;

/**
 * @description: 容易理解的递归解法
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/yi-dian-bu-cheng-shou-de-xiao-xiang-fa-b-yohu/
 * @author: zhanghailang
 * @date: 2020-12-21 9:56
 */
public class EasyDiGuiReverseList {
    public static DiGuiReverseList.Node reverseList(DiGuiReverseList.Node head){
        if (head == null && head.next == null){
            return head;
        }
        DiGuiReverseList.Node hasDone = reverseList(head.next);
        DiGuiReverseList.Node end = new DiGuiReverseList.Node(head.val);
        DiGuiReverseList.Node curr = hasDone;
        while (curr.next != null){
            curr = curr.next;
        }
        curr.next = end;
        return hasDone;
    }
}