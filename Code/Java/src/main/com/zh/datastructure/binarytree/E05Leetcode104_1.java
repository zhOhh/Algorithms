package main.com.zh.datastructure.binarytree;

/**
 * 二叉树最大深度 - 使用后序遍历求解
 */
public class E05Leetcode104_1 {
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
//        if (node.left == null && node.right == null) {
//            return 1;
//        }
        int d1 = maxDepth(node.left);
        int d2 = maxDepth(node.right);
        return Integer.max(d1, d2) + 1;
    }
}
