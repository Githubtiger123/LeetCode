package com.enumeration.java;
//1373. 二叉搜索子树的最大键值和

public class L1373 {

    private class TreeNode {
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

    private class Info {
        public long max;
        public long min;
        public boolean isBst;
        public int max_Size;
        public int sum;

        public Info(long max, long min, boolean isBst, int max_Size, int sum) {
            this.max = max;
            this.min = min;
            this.isBst = isBst;
            this.max_Size = max_Size;
            this.sum = sum;
        }
    }

    private Info func(TreeNode tree) {
        if (tree == null) {
            return new Info(Long.MIN_VALUE, Long.MAX_VALUE, true, 0, 0);
        }
        Info leftNode = func(tree.left);
        Info rightNode = func(tree.right);
        boolean isBst = leftNode.isBst && rightNode.isBst && leftNode.max < tree.val && rightNode.min > tree.val;
        long max = Math.max(tree.val, Math.max(leftNode.max, rightNode.max));
        long min = Math.min(tree.val, Math.min(leftNode.min, rightNode.min));
        int size = Math.max(leftNode.max_Size, rightNode.max_Size);
        if (isBst) {

            size = Math.max(size, leftNode.sum + rightNode.sum + tree.val);
        }
        return new Info(max, min, isBst, size, leftNode.sum + rightNode.sum + tree.val);

    }

    public int maxSumBST(TreeNode root) {

        Info func = func(root);
        return Math.max(func.max_Size, 0);
    }
}
