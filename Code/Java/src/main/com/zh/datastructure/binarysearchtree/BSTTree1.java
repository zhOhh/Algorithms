package main.com.zh.datastructure.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Search Tree 二叉搜索树
 */
public class BSTTree1 {

    BSTNode root; // 根节点

    static class BSTNode {
        int key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


    /**
     * <h3>查找关键字对应的值</h3>
     *
     * @param key 关键字
     * @return 关键字对应的值
     */
    public Object get(int key) {
        return null;
    }

    public Object doGet(BSTNode node, int key) {
        if (node == null) {
            return null; // 没找到
        }

        if (key < node.key) {
            return doGet(node.left, key); // 向左找
        } else if (key > node.key) {
            return doGet(node.right, key); // 向右找
        } else {
            return node.value; // 找到了
        }
    }


    /**
     * <h3>查找最小关键字对应值</h3>
     *
     * @return 关键字对应的值
     */
    public Object min() {
        return doMin(root);
    }

    public Object doMin(BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.value;
        }
        return doMin(node.left);
    }


    /**
     * <h3>查找最大关键字对应值</h3>
     *
     * @return 关键字对应的值
     */
    public Object max() {
        if (root == null) {
            return null;
        }
        BSTNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        return p.value;
    }

    private Object max(BSTNode node) {
        return max(root);
    }


    /**
     * <h3>存储关键字和对应值</h3>
     *
     * @param key   关键字
     * @param value 对应值
     */
    public void put(int key, Object value) {
        BSTNode node = root;
        BSTNode parent = null;
        while (node != null) {
            parent = node;
            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            } else {
                node.value = value;
                return;
            }
        }

        if (parent == null) {
            root = new BSTNode(key, value);
            return;
        }

        if (key < parent.key) {
            parent.left = new BSTNode(key, value);
        } else if (key > parent.key) {
            parent.right = new BSTNode(key, value);
        }

    }


    /**
     * <h3>查找关键字的前驱值</h3>
     *
     * @param key 关键字
     * @return 前驱值
     */
    public Object successor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromLeft = null;
        while (p != null) {
            if (key < p.key) {
                p = p.left;
            } else if (p.key < key) {
                ancestorFromLeft = p;
                p = p.right;
            } else {
                break;
            }
        }

        //没找到节点
        if (p == null) {
            return null;
        }

        if (p.left != null) {
            return max(p.left);
        }

        return ancestorFromLeft != null ? ancestorFromLeft.value : null;
    }


    /**
     * <h3>查找关键字的后继值</h3>
     *
     * @param key 关键字
     * @return 前驱值
     */
    public Object predecessor(int key) {
        BSTNode p = root;
        BSTNode ancestorFromRight = null;
        while (p != null) {
            if (key < p.key) {
                ancestorFromRight = p;
                p = p.left;
            } else if (p.key < key) {
                p = p.right;
            } else {
                break;
            }
        }

        //没找到节点
        if (p == null) {
            return null;
        }

        if (p.right != null) {
            return max(p.right);
        }

        return ancestorFromRight != null ? ancestorFromRight.value : null;
    }

    /**
     * <h3>根据关键字删除</h3>
     *
     * @param key 关键字
     * @return 被删除关键字对应值
     */
    public Object delete(int key) {
        BSTNode p = root;
        BSTNode parent = null;
        while (p != null) {
            if (key < p.key) {
                parent = p;
                p = p.left;
            } else if (p.key < key) {
                parent = p;
                p = p.right;
            } else {
                break;
            }
        }
        if (p == null) {
            return null;
        }
        if (p.left == null) {
            shift(parent, p, p.right);
        } else if (p.right == null) {
            shift(parent, p, p.left);
        } else {
            BSTNode s = p.right;
            BSTNode sParent = p;
            while (s.left != null) {
                sParent = s;
                s = s.left;
            }
            if (sParent != p) {
                shift(sParent, s, s.right);
                s.right = p.right;
            }
            shift(parent, p, s);
            s.left = p.left;
        }
        return p.value;
    }

    /**
     * 托孤方法
     *
     * @param parent  被删除节点的父亲
     * @param deleted 被删除节点
     * @param child   被顶上去的节点
     */
    private void shift(BSTNode parent, BSTNode deleted, BSTNode child) {
        if (parent == null) {
            root = child;
        } else if (deleted == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    //找到 < key 的所有 value
    public List<Object> less(int key) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                if (pop.key < key) {
                    result.add(pop.key);
                } else {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }

    //找到 > key 的所有 value
    public List<Object> greater(int key) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.right;
            } else {
                BSTNode pop = stack.pop();
                if (pop.key > key) {
                    result.add(p.value);
                }else {
                    break;
                }
                p = pop.left;
            }
        }
        return result;
    }

    //找到 >= key1 且 <= key2 的所有 value
    public List<Object> between(int key1, int key2) {
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode pop = stack.pop();
                if (pop.key >= key1 && pop.key <= key2) {
                    result.add(pop.value);
                } else if (pop.key > key2) {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }

}
