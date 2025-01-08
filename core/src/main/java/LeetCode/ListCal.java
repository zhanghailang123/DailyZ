package LeetCode;

/**
 * @description: https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode-solution/
 * 两数相加
 * @author: zhanghailang
 * @date: 2021-5-8 14:23
 */
public class ListCal {
    static class Node{
        private int val;
        Node next;
        private Node(){};
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
    private Node buildNode(int[] array,Node p){
        Node head = new Node(array[0]);
        p = head;
        for (int i = 1; i < array.length; i ++){
            p.next = new Node(array[i]);
            p = p.next;
        }
        return head;
    }
    public Node solution(Node l1,Node l2){
//        //两个链表不一样怎么补0  怎么进位
//        Node re = new Node();
//        while (n1.next != null && n2.next != null){
//           int sum =  n1.val + n2.val;
//           int cur = sum % 10;
//
//        }

//        Node head = null,tail = null;
//        int carry = 0;
//        while (n1 != null || n2 != null){
//            int p1 = n1 != null ? n1.val : 0;
//            int p2 = n2 != null ? n2.val : 0;
//            int sum = p1 + p2 + carry;
//            if (head == null){
//                head = tail = new Node(sum % 10);
//            } else {
//                tail.next = new Node(sum % 10);
//                tail = tail.next;
//            }
//            carry = sum / 10;
//            if (n1 != null){
//                n1 = n1.next;
//            }
//            if (n2 != null){
//                n2 = n2.next;
//            }
//        }
//        if (carry > 0){
//            tail.next = new Node(carry);
//        }
        Node head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new Node(sum % 10);
            } else {
                tail.next = new Node(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new Node(carry);
        }


        return head;
    }

    public static void main(String[] args){
        ListCal cal = new ListCal();
        int[] array = {1,2,3,9};
//        int[] array = {2,4,3};
//        int[] array2 = {5,6,4};
//        int a = 13;
//        int b = 13/10;
        System.out.println(cal.buildNode(array,new Node()).toString());
//        System.out.println(13%10);
//        System.out.println(b);



        Node n1 = cal.buildNode(array,new Node());
        Node n2 = cal.buildNode(array,new Node());
        Node re = cal.solution(n1,n2);
        System.out.println(re.toString());
        while (re != null ){
            System.out.println(re.val);
            re = re.next;
        }

    }
}