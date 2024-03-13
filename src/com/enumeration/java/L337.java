package com.enumeration.java;

//337. 打家劫舍 III
public class L337 {

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
        public int maxIncome;
        public int maxIncome_Son;

        public Info(int maxIncome, int maxIncome_Son) {
            this.maxIncome = maxIncome;
            this.maxIncome_Son = maxIncome_Son;
        }
    }

    public Info func(TreeNode node) {
        if (node == null) {
            return new Info(0, 0);
        }

        Info L = func(node.left);
        Info R = func(node.right);


        int maxIncome = node.val + L.maxIncome_Son + R.maxIncome_Son;
        maxIncome = Math.max(maxIncome, L.maxIncome + R.maxIncome);
        return new Info(maxIncome, L.maxIncome + R.maxIncome);
    }

    public int rob(TreeNode root) {

        return func(root).maxIncome;
    }
}