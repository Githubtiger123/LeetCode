package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;


//983. 最低票价
public class L983 {

//    int func(int ticket, int day, int cost, int[] days, int[] costs) {
//
//        if (day >= days.length) {
//            return cost;
//        }
//
//        if (ticket >= days[day]) {
//            return func(ticket, day + 1, cost, days, costs);
//        } else {
//            int i = func(1 + days[day], day, cost + costs[0], days, costs);
//            int j = func(7 + days[day], day, cost + costs[1], days, costs);
//            int k = func(30 + days[day], day, cost + costs[2], days, costs);
//            return Math.min(i, Math.min(j, k));
//        }
//    }

    private static final int[] temp = new int[]{1, 7, 30};


    int func(int[] days, int[] costs, int day, int[] dp) {

        int ans = 0;
        if (day == days.length) {
            return 0;
        } else if (dp[day] != -1) {

            return dp[day];
        } else {

            ans = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {

                int j = day;
                while (j < days.length && days[j] < days[day] + temp[i]) {
                    j++;
                }

                ans = Math.min(ans, func(days, costs, j, dp) + costs[i]);
            }
        }
        dp[day] = ans;
        return ans;
    }

    public int mincostTickets(int[] days, int[] costs) {


//        int[] dp = new int[days.length];
//        Arrays.fill(dp, -1);
//        return func(days, costs, 0, dp);

        int n = days.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 0; k < 3; k++) {

                int j = i;
                while (j < days.length && days[j] < days[i] + temp[k]) {
                    j++;
                }

                dp[i] = Math.min(dp[i], dp[j] + costs[k]);
            }
        }
        return dp[0];
    }

    @Test
    public void test() {

        int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        int[] costs = {2, 7, 15};
        System.out.println(mincostTickets(days, costs));
        System.out.println(mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
    }
}
