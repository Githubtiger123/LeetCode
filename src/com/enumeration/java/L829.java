package com.enumeration.java;

import org.junit.Test;

import java.util.Scanner;

public class L829 {

    @Test
    public void test(){

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(consecutiveNumbersSum(n));
    }

    //超时
//    public static int consecutiveNumbersSum(int n) {
//        int count = 0;
//        for (int i = 1; i <= n; i++) {
////            int[] arr = new int[n];
//            int sum = 0;
//            for (int j = i; j <= n; j++) {
//                sum+=j;
//                if(sum>=n){
//                    break;
//                }
//            }
//            if(sum==n){
//                count++;
//            }
//        }
//        return count;
//    }

    //方法二:滑动窗口时间o(n),时间仍然超出限制
//    public static int consecutiveNumbersSum(int n) {
//        int count = 0;
//        int sum = 0;
//        int start = 1;
//
//        for (int end = 1; end <= n; end++) {
//            sum+=end;
//            while(sum>n){
//                sum-=start;
//                start++;
//            }
//            if(sum==n){
//                count++;
//            }
//        }
//        return count;
//    }

    //方法三数学方法
    public static int consecutiveNumbersSum(int n) {
        int ans = 0;
        for (int k = 1; k * k < 2 * n; k++) {
            if (2 * n % k == 0 && (2 * n / k - k + 1) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}
