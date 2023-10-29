package main.com.zh.algorithm.twothreetree;

import java.util.Arrays;

public class BTree {

    static class Node {
        int[] keys; //关键字
        Node[] children; //孩子
        int keyNumber; //有效关键字数目
        boolean leaf = true; //叶子节点
        int t; //最小度数(最小孩子数)

        public Node(int t) { // t >= 2
            this.t = t;
            this.children = new Node[2 * t];
            this.keys = new int[2 * t - 1];
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys,0,keyNumber));
        }

        // 多路查找
        // 向指定索引插入 key
        // 向指定索引插入 child
    }

}
