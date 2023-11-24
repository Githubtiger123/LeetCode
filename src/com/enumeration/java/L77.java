package com.enumeration.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//77.组合
public class L77 {

    @Test
    public void test() {

        System.out.println(combine(5, 3));
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList();
        List<Integer> path = new ArrayList();
        backTracking(n, k, 1, path, result);
        return result;
    }

    private static void backTracking(int n, int k, int startIndex, List<Integer> path, List<List<Integer>> result) {

        if (path.size() == k) {
            result.add(new ArrayList(path));
            return;
        }

        //添加剪枝操作
        if (path.size() + (n - startIndex) + 1 < k) {
            return;
        }

        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backTracking(n, k, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    //注意，全局变量需要每次重新赋值才可以
    //全局变量会有冲突
//    static List<List<Integer>> result = new ArrayList();
//    static List<Integer> path = new ArrayList();
//
//    public static List<List<Integer>> combine(int n, int k) {
//
//        init();
//        backTracking(n, k, 1);
//        return result;
//    }
//
//    //全局变量问题！！！
//    private static void init() {
//        result = new ArrayList();
//        path = new ArrayList();
//    }
//
//    private static void backTracking(int n, int k, int startIndex) {
//
//        if (path.size() == k) {
//            result.add(new ArrayList(path));
//            return;
//        }
//
//        for (int i = startIndex; i <= n; i++) {
//            path.add(i);
//            backTracking(n, k, i + 1);
//            path.remove(path.size() - 1);
//        }
//    }
}
