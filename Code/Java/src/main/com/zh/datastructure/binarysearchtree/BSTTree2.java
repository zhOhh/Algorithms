package main.com.zh.datastructure.binarysearchtree;

/**
 * Binary Search Tree 二叉搜索树 泛型key版本
 */
public class BSTTree2<T extends Comparable<T>> {

    static class BSTNode<T> {
        T key;
        Object value;
        BSTNode<T> left;
        BSTNode<T> right;

        public BSTNode(T key) {
            this.key = key;
        }

        public BSTNode(T key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(T key, Object value, BSTNode<T> left, BSTNode<T> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    BSTNode<T> root;

    public Object get(T key) {
        BSTNode<T> p = root;
        while (p != null) {
            //key p.key
            /*
                -1 key < p.key
                0 key = p.key
                1 key > p.key
             */
            int result = key.compareTo(p.key);
            if (result < 0) {
                p = p.left;
            } else if (result > 0) {
                p = p.right;
            } else {
                return p.value;
            }
        }
        return null;
    }

}
