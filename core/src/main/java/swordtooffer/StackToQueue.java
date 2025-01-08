package swordtooffer;

import java.util.Queue;
import java.util.Stack;

/**
 * @description: 用两个栈实现一个队列
 * @author: zhanghailang
 * @date: 2021-6-1 11:14
 */
public class StackToQueue {
    Stack<Integer> stackA ;
    Stack<Integer> stackB ;
    public StackToQueue() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void appendTail(int value) {
        stackA.push(value);
    }

    public int deleteHead() {
        if (stackB.isEmpty()){
            while(!stackA.isEmpty()){
                stackB.push(stackA.pop());
            }
        }
        if(stackB.isEmpty()){
            return -1;
        }
        int t = stackB.pop();
        return t;

    }

    public static void main(String[] args) {
        StackToQueue queue = new StackToQueue();
        queue.appendTail(5);
        queue.appendTail(2);
        // 中 左 右
        // 左 中 右
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        // ReBuild TreeNode
    }
}