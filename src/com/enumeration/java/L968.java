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

    private static int ans = 0;

    private int f(TreeNode node) {

        if (node == null) {
            return 1;
        }
        int left = f(node.left);
        int right = f(node.right);
        if (left == 0 || right == 0) {
            ans++;
            return 2;
        }
        if (left == 1 && right == 1) {
            return 0;
        }
        return 1;
    }

    public int minCameraCover(TreeNode root) {

        ans = 0;//全局变量共享清零
        int status = f(root);
        if (status == 0) {
            return ans + 1;
        }
        return ans;
    }
}
