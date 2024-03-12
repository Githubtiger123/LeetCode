package com.enumeration.java;

//979. 在二叉树中分配硬币
public class L979 {


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

    private class Info {

        public int ans;
        public int difference_value;
        public int coin;
        public int count;

        public Info(int ans, int difference_value, int coin, int count) {
            this.ans = ans;
            this.difference_value = difference_value;
            this.coin = coin;
            this.count = count;
        }
    }

    public Info func(TreeNode node) {

        if (node == null) {
            return new Info(0, 0, 0, 0);
        }

        Info L = func(node.left);
        Info R = func(node.right);

        int coin = L.coin + R.coin + node.val;
        int count = L.count + R.count + 1;
        int difference_value = count - coin; //可以不用此属性
        int ans = Math.abs(difference_value) + L.ans + R.ans;

        return new Info(ans, difference_value, coin, count);
    }

    public int distributeCoins(TreeNode root) {

        return func(root).ans;
    }
}
