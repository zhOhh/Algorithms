package main.com.zh.datastructure.binarytree;

import java.util.LinkedList;

/**
 * 二叉树最大深度 - 使用层序遍历求解
 */
public class E05Leetcode104_3 {
    public int maxDepth(TreeNode root) {
        if (root==null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
