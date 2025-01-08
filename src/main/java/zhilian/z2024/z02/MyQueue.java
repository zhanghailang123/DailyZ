package main.java.zhilian.z2024.z02;

import java.util.Stack;

/**
 * @author zhanghailang
 * @since 2024/2/5 16:02
 **/
public class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
    }

    public void push(int X) {
        stackIn.push(X);
    }

    public int pop() {
        return stackOut.pop();
    }

    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    private void dumpStackIn() {
        if (!stackOut.isEmpty()) {
            return;
        }

        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
