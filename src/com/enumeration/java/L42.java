package com.enumeration.java;

import org.junit.Test;

//42. 接雨水
public class L42 {

    public int trap1(int[] height) {

        int n = height.length;
        int ans = 0;
        int[] left_max = new int[n];
        left_max[0] = height[0];
        int[] right_max = new int[n];
        right_max[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }
        for (int i = 0; i < n; i++) {
            int diif = Math.min(left_max[i], right_max[i]) - height[i];
            ans += Math.max(diif, 0);
        }

        return ans;
    }

    public int trap(int[] height) {

        int n = height.length;
        if (n <= 2) {
            return 0;
        }
        int l = 1;
        int r = n - 2;
        int ans = 0, l_max = height[0], r_max = height[n - 1];

        while (l <= r) {

            if (l_max < r_max) {

                ans += Math.max(l_max - height[l], 0);
                l_max = Math.max(l_max, height[l]);
                l++;
            } else {
                ans += Math.max(r_max - height[r], 0);
                r_max = Math.max(r_max, height[r]);
                r--;
            }
        }
        return ans;
    }

    @Test
    public void test() {

        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{8}));
        System.out.println(trap(new int[]{0, 0, 0, 0}));
        System.out.println(trap(new int[]{0, 0, 0, 0, 5}));
        System.out.println(trap(new int[]{0, 0, 1, 0, 5}));
    }
}
