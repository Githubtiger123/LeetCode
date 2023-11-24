package com.enumeration.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//40. 组合总和 II
public class L40 {

    @Test
    public void test() {

        System.out.println(combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
        //1 2 2 2 5
    }

    //使用标记数组
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//        boolean[] used = new boolean[candidates.length];
//        Arrays.sort(candidates);
//        backTracking(candidates, target, 0, result, path, 0, used);
//        return result;
//    }
//
//
//    //树枝可以重复,数层不能重复
//    private static void backTracking(int[] candidates, int target, int startIndex, List<List<Integer>> result, List<Integer> path, int sum, boolean[] used) {
//
//        if (sum == target) {
//            result.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i = startIndex; i < candidates.length; i++) {
//
//            //剪枝(不剪会超时)
//            if (candidates[i] + sum > target) {//因为是升序,所以后边就不用看了
//                break;
//            }
//
//            //去重操作(树层)
//            if (i > 0 && candidates[i - 1] == candidates[i] && !used[i - 1]) {
//                continue;
//            }
//
//            used[i] = true;
//            path.add(candidates[i]);
//            sum += candidates[i];
//            backTracking(candidates, target, i + 1, result, path, sum, used);
//
//            //回溯
//            Integer remove = path.remove(path.size() - 1);
//            sum -= remove;
//            used[i] = false;
//        }
//    }

    //不使用标记数组
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(candidates, target, 0, result, path, 0);
        return result;
    }


    //树枝可以重复,数层不能重复
    private static void backTracking(int[] candidates, int target, int startIndex, List<List<Integer>> result, List<Integer> path, int sum) {

        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {

            //剪枝(不剪会超时)
            if (candidates[i] + sum > target) {//因为是升序,所以后边就不用看了
                break;
            }

            //去重操作(树层)
            if (i > startIndex && candidates[i - 1] == candidates[i]) {
                continue;
            }

            path.add(candidates[i]);
            sum += candidates[i];
            backTracking(candidates, target, i + 1, result, path, sum);

            //回溯
            Integer remove = path.remove(path.size() - 1);
            sum -= remove;
        }
    }
}
