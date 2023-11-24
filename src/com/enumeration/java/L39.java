package com.enumeration.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//39. 组合总和
public class L39 {

    @Test
    public void test() {

        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTracking(candidates, target, 0, result, path, 0);
        return result;
    }

    private static void backTracking(int[] candidates, int target, int startIndex, List<List<Integer>> result, List<Integer> path, int sum) {

        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            path.add(candidates[i]);
            sum += candidates[i];
            backTracking(candidates, target, i, result, path, sum);

            //回溯
            Integer remove = path.remove(path.size() - 1);
            sum -= remove;
        }
    }
}
