package com.enumeration.java;

public class L968 {

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

        int ans;
        int status;

        public Info(int ans, int status) {
            this.ans = ans;
            this.status = status;
        }
    }

    public Info func(TreeNode node) {
        if (node == null) {
            return new Info(0, 1);
        }

        Info L = func(node.left);
        Info R = func(node.right);

        if (L.status == 0 || R.status == 0) {

            return new Info(L.ans + R.ans + 1, 2);
        }

        if (L.status == 1 && R.status == 1) {

            return new Info(L.ans + R.ans, 0);
        }
        if (L.status == 2 || R.status == 2) {
            return new Info(L.ans + R.ans, 1);
        }

        throw new RuntimeException();
    }

    public int minCameraCover(TreeNode root) {

        if (root != null && root.left == null && root.right == null) {

            return 1;
        }
        Info func = func(root);
        System.out.println(func.status);
        if (func.status == 0) {
            return func.ans + 1;
        }
        return func.ans;
    }
}
