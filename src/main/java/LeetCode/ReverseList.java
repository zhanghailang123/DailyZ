package LeetCode;

/**
 * @description: 反转链表--迭代
 * @author: zhanghailang
 * @date: 2020-12-14 17:38
 */
public class ReverseList {



    public static Node rerverseList(Node head){
//        Node prev = null;
//        //1 2 3 4 5
//        Node cur = head;
//        while(cur != null){
//            // 2 3 4 5
//            // 3 4 5
//            // 4 5
//            // 5
//            // null
//            Node temp = cur.next;
//            // null
//            // 1
//            // 2 1
//            // 3 2 1
//            // 4 3 2 1
//            cur.next = prev;
//            // 1
//            // 2 1
//            // 3 2 1
//            // 4 3 2 1
//            prev = cur;
//            // 2 3 4 5
//            // 3 4 5
//            // 4 5
//            // 5
//            cur = temp;
//
//        }
//        return prev;
        //再来一次
        Node result = null;
        while (head != null){
            //先将Node的next节点保存，以便接下来循环使用next从而实现链表的反转 下面一步会修改head.next 这样对引用来说是不是会有问题
            Node temp = head.next;
            head.next = result;
            //循环构建反转后的链表
            result = head;
            //将head的next赋值给下一次循环的head
            head = temp;
        }
        return result;
//        Node prev = null;
//        Node curr = head;
//        while (curr != null) {
//            head = curr;
//            curr = curr.next;
//            head.next = prev;
//            prev = head;
//        }
//        return head;
//        Node pre = null;
//
//        while (head != null) {
//            Node curr = head;
//            pre = curr;
//            curr.next = null;
//            head = head.next;
//        }
//
//        return pre;
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
        }
        return head;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4,5};
        Node node = buildNodeList(test);
        Node result = rerverseList(node);
        while (result != null){
            System.out.println("结果为：" + result.val);
            result = result.next;
        }

        //确实这样 当一个引用赋值给另一个引用时，另一个引用改变时。会导致一个引用的值也发生变换
//        Node test1  =  new Node(5);
//        test1.next = new Node(6);
//        Node temp = test1;

//        Node test2 = test1.next;
//        Node test3 = test1;
//        test1.next = new Node(9);
//        System.out.println(test2.val + "  比较   " + test3.next.val);
    }
}

