package com.enumeration.java;

import org.junit.Test;

import java.util.Arrays;

public class L204 {

    @Test
    public void test(){
        System.out.println(countPrimes(5666666));
    }
//方式一:时间超限
//    public static int countPrimes(int n) {
//
//        int count = 0;
//        for (int i = 2; i < n; i++) {
//            count = isPrime(i)?count+1:count;
//        }
//        return count;
//    }
//
//    private static boolean isPrime(int n){
//
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if(n%i==0){
//                return false;
//            }
//        }
//        return true;
//    }

    //方式二
//    public static int countPrimes(int n) {
//
//        int[] nums = new int[(int) Math.sqrt(n)];
//        int count = 0;
//        int new_count = 0;
//        if(n==0||n==1)return 0;
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if(isPrime(i)){
//                nums[count++] = i;
//            }
//        }
//        new_count = count;
//        for (int i = (int) (Math.sqrt(n)+1); i < n; i++) {
//            boolean flag = true;
//            for (int j = 0; j < count; j++) {
//                if(i%nums[j]==0){
//                    flag = false;
//                    break;
//                }
//            }
//            new_count+=flag?1:0;
//        }
//        return new_count;
//    }
//
//        private static boolean isPrime(int n){
//
//        for (int i = 2; i <= Math.sqrt(n); i++) {
//            if(n%i==0){
//                return false;
//            }
//        }
//        return true;
//    }

    //方式三
    private static int countPrimes(int n){

        int count = 0;
        boolean[] nums = new boolean[n+1];
        Arrays.fill(nums,true);
        if(n==0||n==1)return 0;
        nums[0] = false;
        nums[1] = false;
        for (int i = 2; i <= Math.sqrt(n); i++) {

            if(nums[i]){
                for (int j = i*i; j <= n; j+=i) {
                    nums[j] = false;
                }
            }
        }

        for (int i = 0; i < n + 1; i++) {
            if(nums[i]){
                count++;
            }
        }
        return count;
    }
}
