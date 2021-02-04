package Web;

/**
 * @description: 链表相关的使用，快慢指针等等  重排链表
 * @author: zhanghailang
 * @date: 2020/9/14 0014 19:19
 */
class ListNode {
    int val;
    ListNode next;
}
public class ListNode1{
    public void resortedList(ListNode head){
        if (head != null && head.next != null){
            return;
        }
        //步骤一 通过快慢指针找到链表中点
        //通过调整快慢指针的起始位置，可以保证前半部分的长度大于等于后半部分
        ListNode slow = head,fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //步骤二 翻转后半部分链表
        //在翻转之前需要将前后两部分链表断开
        ListNode second = slow.next;
        slow.next = null;
        second = reverseList(second);
    }

    private ListNode reverseList(ListNode second) {
            return  second;
    }

    public static void main(String[] args) {

    }
}


