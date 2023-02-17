package com.zhanghl.first.service.impl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hailang.zhang
 * @since 2023-02-16
 */
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache {

    //learned what mainly analisys function dont be no brain ok bro fine thanks and you
    private HashMap<Integer, Node> cache = new HashMap<Integer, Node>();
    private int cap;
    private DoubleList list = new DoubleList();
    public LRUCache(int capacity) {
        cap = capacity;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        int a = lruCache.get(1);
        lruCache.put(3,3);
        int b = lruCache.get(2);
        lruCache.put(4,4);
    }

    /**
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (cache.get(key) == null) {
            return -1;
        }

        //delete and addLast
        Node node = cache.get(key);
        list.remove(node);
        list.addLast(node);
        cache.put(key, node);
        return node.val;
    }

    public void put(int key, int value) {

        if (cache.get(key) != null) {
            Node node = cache.get(key);
            list.remove(node);
            list.addLast(node);
            cache.put(key, node);
            return;
        }


        if (list.getSize() == cap) {
            //移除最后一个
            Node node = new Node(key, value);
            Node removed = list.removeLast();
            list.addLast(node);
            cache.put(key, node);
            cache.remove(removed.key);
        } else {
            Node node = new Node(key, value);
            list.addLast(node);
            cache.put(key, node);
        }
    }
}

//default that all of you know the qianti
class Node {
    public int key, val;
    public Node pre, next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

//input output 输入和输出
//define : shi function LRU  fogot the function meaning

class DoubleList {
    public Node head;
    public Node tail;
    public int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    /**
     * d
     * 已知c
     * 1.do b && d
     * 2.do d && c
     * a->b->c
     * 在尾部添加元素
     * @param node
     */
    public void addLast(Node node) {
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
        size ++;
    }

    /**
     * x一定存在
     * 已知node的情况下
     * a-node-b
     * a-b
     * @param node
     */
    public void remove(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
        node.pre = null;
        node.next = null;
        size --;
    }

    /**
     * a-node-c-b
     * @return
     */
    public Node removeLast() {
        Node node = head.next;
        node.next.pre = node.pre;
        node.pre.next = node.next;
        node.pre = null;
        node.next = null;
        size --;
        return node;
    }

    public int getSize() {
        return this.size;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)
