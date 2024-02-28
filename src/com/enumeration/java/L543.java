package com.enumeration.java;

//543. 二叉树的直径
public class L543 {
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

//    private class Info {
//        public int max_Size;
//        public int max_Left;
//        public int max_Right;
//        public int res;
//
//
//        public Info(int max_Size, int max_Left, int max_Right, int res) {
//            this.max_Size = max_Size;
//            this.max_Left = max_Left;
//            this.max_Right = max_Right;
//            this.res = res;
//        }
//    }

    private class Info{

        public int diameter;
        public int high;

        public Info(int diameter, int high) {
            this.diameter = diameter;
            this.high = high;
        }
    }

    public Info func(TreeNode tree){

        if(tree == null){
            return new Info(0,0);
        }else {
            Info L = func(tree.left);
            Info R = func(tree.right);
            int diameter = tree.left.
        }
    }

//    public Info func(TreeNode tree) {
//
//        if (tree == null) {
//            return new Info(0, 0, 0, 0);
//        }
//        Info L = func(tree.left);
//        Info R = func(tree.right);
//        int max_Left = L.max_Size + 1;
//        int max_Right = R.max_Size + 1;
//        int result = max_Left + max_Right;
//        result = Math.max(result, Math.max(L.res, R.res));
//        return new Info(Math.max(max_Left, max_Right), max_Left, max_Right, result);
//    }
//
//    public int diameterOfBinaryTree(TreeNode root) {
//
//        return func(root).res - 2;
//    }
}
