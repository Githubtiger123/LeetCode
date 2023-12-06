package com.enumeration.java;

import org.junit.Test;

import java.util.HashMap;
//397. 整数替换
public class L397 {

    @Test
    public void test() {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(integerReplacement(Integer.MAX_VALUE));
    }

    public int integerReplacement(int n) {

        HashMap<Long, Long> map = new HashMap<>();
        return (int) backtracking(n, map);
    }

    public long backtracking(long n, HashMap<Long, Long> map) {

        if (map.get(n) != null) {
            return map.get(n);
        }

        long ans = 0;
        if (n == 1) {
            ans = 0;
        } else if (n % 2 == 0) {
            return 1 + backtracking(n / 2, map);
        } else {
            long n1 = 1 + backtracking(n - 1, map);
            long n2 = 1 + backtracking(n + 1, map);
            ans = Math.min(n1, n2);
        }
        map.put(n, ans);
        return ans;
    }
    //特别注意!!!!!!!!!!!!!!!!!!N为Integer.MAX_VALUE+1时会溢出!!!!!!!!!!!!!
    /**
     * 当 n 等于 2^31 - 1 时，计算 n + 1 会导致整数溢出。为了安全地处理这种情况，我们可以使用整数除法来计算 (n + 1) / 2 和 (n - 1) / 2，其中 ⌊x⌋ 表示对 x 向下取整。
     *
     * 具体来说：
     *
     * 对于 n + 1 的情况，由于直接计算 n + 1 会溢出，我们可以先对 n 除以 2，然后向结果中加 1，即 ⌊n / 2⌋ + 1。
     * 对于 n - 1 的情况，我们可以直接计算 n - 1 然后除以 2，即 ⌊(n - 1) / 2⌋。
     * 这样，我们就避免了在整数运算中可能发生的溢出问题。
     */
}
