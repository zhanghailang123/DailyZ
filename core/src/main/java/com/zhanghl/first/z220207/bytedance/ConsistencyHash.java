package com.zhanghl.first.z220207.bytedance;

import cn.hutool.bloomfilter.filter.FNVFilter;
import cn.hutool.core.util.HashUtil;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @description: 一致性hash算法的实现
 * @author: zhanghailang
 * @date: 2022/10/20 14:43
 */
public class ConsistencyHash {

    /**
     * 物理节点
     */
    private TreeSet<String> physicalNodes = new TreeSet<String>() {
        {
            add("192.168.1.101");
            add("192.168.1.102");
            add("192.168.1.103");
            add("192.168.1.104");
            add("192.168.1.105");
            add("192.168.1.106");
        }
    };

    private final int VIRTUAL_COPIES = 1;

    private TreeMap<Long, String> virtualNodes = new TreeMap<>();

    public ConsistencyHash() {
        for (String nodeIp : physicalNodes) {
            addPhsicalNode(nodeIp);
        }
    }

    public void addPhsicalNode(String nodeIP) {
        for (int i = 0; i < VIRTUAL_COPIES; i++) {
            Long hash = FNVHash(nodeIP + "#" + i);
            virtualNodes.put(hash, nodeIP);
        }
    }

    public void removePhsicalNode(String nodeIP) {
        for (int idx = 0; idx < VIRTUAL_COPIES; ++idx) {
            long hash = FNVHash(nodeIP + "#" + idx);
            virtualNodes.remove(hash);
        }
    }

    public String getObjectNode(String object) {
        Long hash = FNVHash(object);
        SortedMap<Long, String> tailMap = virtualNodes.tailMap(hash);
        Long key = tailMap.isEmpty() ? virtualNodes.firstKey() : tailMap.firstKey();
        return virtualNodes.get(key);
    }

    // 统计对象与节点的映射关系
    public void dumpObjectNodeMap(String label, int objectMin, int objectMax) {
        // 统计
        Map<String, Integer> objectNodeMap = new TreeMap<>(); // IP => COUNT
        for (int object = objectMin; object <= objectMax; ++object) {
            String nodeIp = getObjectNode(Integer.toString(object));
            Integer count = objectNodeMap.get(nodeIp);
            objectNodeMap.put(nodeIp, (count == null ? 0 : count + 1));
        }

        // 打印
        double totalCount = objectMax - objectMin + 1;
        System.out.println("======== " + label + " ========");
        for (Map.Entry<String, Integer> entry : objectNodeMap.entrySet()) {
            long percent = (int) (100 * entry.getValue() / totalCount);
            System.out.println("IP=" + entry.getKey() + ": RATE=" + percent + "%");
        }
    }


    // 32位的 Fowler-Noll-Vo 哈希算法
    // https://en.wikipedia.org/wiki/Fowler–Noll–Vo_hash_function
    private static Long FNVHash(String key) {
        final int p = 16777619;
        Long hash = 2166136261L;
        for (int idx = 0, num = key.length(); idx < num; ++idx) {
            hash = (hash ^ key.charAt(idx)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }

    public static void main(String[] args) {
        ConsistencyHash ch = new ConsistencyHash();

        // 初始情况
        ch.dumpObjectNodeMap("初始情况", 0, 65536);

        // 删除物理节点
        ch.removePhsicalNode("192.168.1.103");
        ch.dumpObjectNodeMap("删除物理节点", 0, 65536);

        // 添加物理节点
        ch.addPhsicalNode("192.168.1.108");
        ch.dumpObjectNodeMap("添加物理节点", 0, 65536);
    }

}