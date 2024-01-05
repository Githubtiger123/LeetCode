package com.enumeration.java;

import org.junit.Test;

import java.util.List;
import java.util.TreeSet;

//632. 最小区间
public class L632 {

    @Test
    public void test() {


    }

    public int[] smallestRange(List<List<Integer>> nums) {

        int n = nums.size();
        int ans = Integer.MAX_VALUE;
        class Node {
            int index_x;
            int index_y;
            int value;

            public Node(int index_x, int index_y, int value) {
                this.index_x = index_x;
                this.index_y = index_y;
                this.value = value;
            }
        }

        //为什么不按纸大小排下序?因为一样的就被覆盖了
        TreeSet<Node> node = new TreeSet<>((a, b) -> (a.value != b.value ? a.value - b.value : (a.index_x - b.index_x)));
        for (int i = 0; i < n; i++) {
            node.add(new Node(i, 0, nums.get(i).get(0)));
        }

        int x = 0, y = 0;
        while (node.size() == n) {
            Node max = node.last();
            Node min = node.pollFirst();
            if (max.value - min.value < ans) {
                ans = max.value - min.value;
                x = min.value;
                y = max.value;
            }

            if (min.index_y + 1 < nums.get(min.index_x).size()) {
                node.add(new Node(min.index_x, min.index_y + 1, nums.get(min.index_x).get(min.index_y + 1)));
            }

        }

        return new int[]{x, y};
    }
}
