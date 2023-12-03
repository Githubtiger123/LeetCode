package com.enumeration.java;

import org.junit.Test;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

//113. 路径总和 II
public class L113 {


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

    @Test
    public void test() {


    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {


        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtracking(root, targetSum, result, path);
        return result;
    }

    public void backtracking(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path) {

        if (root == null) {
            return;
        }
        path.add(root.val);
        targetSum -= root.val;
        if (targetSum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(path));
        }
        backtracking(root.left, targetSum, result, path);
        backtracking(root.right, targetSum, result, path);
        path.remove(path.size() - 1);
    }

//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//
//
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//        if(root== null) {
//            return result;
//        }
//        backtracking(root, targetSum, 0, result, path);
//        System.out.println(result);
//        return result;
//    }
//
//    public void backtracking(TreeNode root, int targetSum, int sum, List<List<Integer>> result, List<Integer> path) {
//
//        if (root.left == null && root.right == null) {
//            if (sum + root.val == targetSum) {
//                path.add(root.val);
//                result.add(new ArrayList<>(path));
//                path.remove(path.size() - 1);
//            }
//            return;
//        } else if (root.left != null && root.right != null) {
//            path.add(root.val);
//            backtracking(root.left, targetSum, sum + root.val, result, path);
//            path.remove(path.size() - 1);
//
//            path.add(root.val);
//            backtracking(root.right, targetSum, sum + root.val, result, path);
//            path.remove(path.size() - 1);
//        } else if (root.left != null) {
//            path.add(root.val);
//            backtracking(root.left, targetSum, sum + root.val, result, path);
//            path.remove(path.size() - 1);
//        } else if (root.right != null) {
//            path.add(root.val);
//            backtracking(root.right, targetSum, sum + root.val, result, path);
//            path.remove(path.size() - 1);
//        }
//    }
}
