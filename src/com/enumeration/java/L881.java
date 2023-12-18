package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

//881. 救生艇
public class L881 {


    @Test
    public void test() {

        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    }

    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int ans = 0;
        int left = 0, right = people.length - 1;
        while (left < right) {

            if (people[left] + people[right] <= limit) {
                ans++;
                left++;
                right--;
            } else {
                ans++;
                right--;
            }
        }
        return left == right ? ans + 1 : ans;
    }
}
