package main.com.zh.datastructure.binarysearchtree;

public class E01Leetcode450 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode deleteNode(TreeNode node, int key) {
            if (node == null) {
                return null;
            }
            if (key < node.val) {
                node.left = deleteNode(node.left, key);
                return node;
            }
            if (node.val < key) {
                node.right = deleteNode(node.right, key);
                return node;
            }
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            TreeNode s = node.right;
            while (s.left != null) {
                s = s.left;
            }
            s.right = deleteNode(node.right, s.val);
            s.left = node.left;
            return s;
        }
    }
}
