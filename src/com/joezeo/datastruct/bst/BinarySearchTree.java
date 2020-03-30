package com.joezeo.datastruct.bst;

/**
 * 二叉搜索树
 * 如果节点的左子树不空，则左子树上所有结点的值均小于等于它的根结点的值；
 * 如果节点的右子树不空，则右子树上所有结点的值均大于等于它的根结点的值；
 * 任意节点的左、右子树也分别为二叉查找树；
 *
 * @author Joezeo
 * @date 2020/3/30 13:46
 */
public class BinarySearchTree<T extends Comparable<T>> {
    public class Node<T extends Comparable<T>> {
        T data;
        Node<T> left; // 左子树
        Node<T> right; // 右子树
        Node<T> parent; // 父节点
    }

    /**
     * 二叉搜索树的根节点，唯一一个父节点为null的节点
     */
    private Node<T> root;

    /**
     * 二叉搜索树的当前大小
     */
    private int size;

    public BinarySearchTree() {
    }

    /**
     * 以data作为root节点的值构造二叉搜索树
     *
     * @param data
     */
    public BinarySearchTree(T data) {
        init(data);
    }

    /**
     * 初始化二叉搜索树：初始化根节点，size
     */
    public void init() {
        this.root = new Node<>();
        this.size = 0;
    }

    /**
     * 初始化二叉搜索树：初始化根节点，size
     */
    public void init(T data) {
        this.root = new Node<>();
        this.root.data = data;
        this.size = 0;
    }

    /**
     * 获取二叉搜索树的当前大小
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 将数据插入二叉搜索树中
     *
     * @param data (#implements Comparable<T>)
     */
    public void put(T data) {
        if (this.root == null) {
            init();
        }
        putVal(data, this.root, null);
    }

    /**
     * 判断二叉搜索树中是否存在该数据
     *
     * @param data
     * @return
     */
    public boolean serach(T data) {
        return searchData(data, this.root);
    }

    /**
     * 删除二叉搜索树中的值为data的节点
     * 如果存在，删除成功返回true
     * 不存在，删除失败返回false;
     *
     * @param data
     * @return
     */
    public boolean delete(T data) {
        return deleteVal(data, this.root, false);
    }


    /**
     * 查找二叉搜索树中的最小值
     *
     * @return
     */
    public T minimum() {
        return minimumSearch(this.root);
    }

    /**
     * 查找二叉搜索树中的最大值
     *
     * @return
     */
    public T maximum() {
        return maximumSearch(this.root);
    }

    /**
     * 前序遍历二叉搜索树
     */
    public void preorder() {
        System.out.println("前序遍历：");
        preorder(this.root);
        System.out.println();
    }

    /**
     * 中序遍历二叉搜索树
     */
    public void inorder() {
        System.out.println("中序遍历：");
        inorder(this.root);
        System.out.println();
    }

    /**
     * 后序遍历二叉搜索树
     */
    public void postorder() {
        System.out.println("后序遍历：");
        postorder(this.root);
        System.out.println();
    }


    /*-------------------------------private methods---------------------------------*/

    /**
     * 将数据插入二叉搜索树中
     * 使用了递归的方式存数据
     *
     * @param data (#implements Comparable<T>)
     * @param cur  当前节点
     * @param pre  上一个节点
     */
    private void putVal(T data, Node<T> cur, Node<T> pre) {
        if (cur.data == null) {
            cur.data = data;
            this.size++;
            if (cur != root) {
                cur.parent = pre;
            }
            return;
        }

        if (data.compareTo(cur.data) < 0) {// 左开右闭原则，左子树的值小于根节点，右子树的值大于等于根节点
            if (cur.left == null) {
                cur.left = new Node<>();
            }
            putVal(data, cur.left, cur);
        } else { // data.compareTo(cur.data) >= 0
            if (cur.right == null) {
                cur.right = new Node<>();
            }
            putVal(data, cur.right, cur);
        }
    }

    /**
     * 寻找二叉搜索树中是否存在该数据
     * 采用了递归的方式
     *
     * @param data 要寻找的数据
     * @param cur  当前节点
     * @return
     */
    private boolean searchData(T data, Node<T> cur) {
        if (cur == null) {
            return false;
        }
        if (cur.data.compareTo(data) == 0) {
            return true;
        }

        if (data.compareTo(cur.data) < 0) {
            return searchData(data, cur.left);
        } else { // data.compareTo(cur.data)>0
            return searchData(data, cur.right);
        }
    }

    /**
     * 删除二叉搜索树中的值为data的节点
     * 如果存在，删除成功返回true
     * 不存在，删除失败返回false;
     *
     * @param data
     * @param cur  当前节点
     * @return
     */
    private boolean deleteVal(T data, Node<T> cur, boolean isRight) {
        if (data.compareTo(cur.data) == 0) {
            // TODO: 完成删除逻辑，参考：https://lufficc.com/blog/binary-search-tree
        }

        if (data.compareTo(cur.data) > 0) {
            return deleteVal(data, cur.right, true);
        } else { // data.compareTo(cur.data) < 0
            return deleteVal(data, cur.left, false);
        }
    }


    /**
     * 寻找二叉搜索树的最小值，即找到树的最左节点
     * 使用迭代
     *
     * @param cur 当前节点
     * @return
     */
    private T minimumSearch(Node<T> cur) {
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.data;
    }

    /**
     * 寻找二叉搜索树的最大值，即找到树的最右节点
     * 使用迭代
     *
     * @param cur 当前节点
     * @return
     */
    private T maximumSearch(Node<T> cur) {
        while (cur.right != null) {
            cur = cur.right;
        }
        return cur.data;
    }

    /**
     * 前序遍历二叉搜索树
     *
     * @param cur
     */
    private void preorder(Node<T> cur) {
        if (cur != null) {
            System.out.print(cur.data + ":");
            preorder(cur.left);
            preorder(cur.right);
        }
    }

    /**
     * 中序遍历二叉搜索树
     *
     * @param cur
     */
    private void inorder(Node<T> cur) {
        if (cur != null) {
            inorder(cur.left);
            System.out.print(cur.data + ":");
            inorder(cur.right);
        }
    }

    /**
     * 后序遍历二叉搜索树
     *
     * @param cur
     */
    private void postorder(Node<T> cur) {
        if (cur != null) {
            postorder(cur.left);
            postorder(cur.right);
            System.out.print(cur.data + ":");
        }
    }

    public Node<T> getRoot() {
        return root;
    }
}
