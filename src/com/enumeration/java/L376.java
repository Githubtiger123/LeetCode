package com.enumeration.java;

import org.junit.Test;
//[51,226,208,165,202,286,190,212,219,271,36,245,20,238,238,89,105,66,73,9,254,206,221,237,203,33,249,253,150,102,57,249,203,10,123,178,85,203,35,276,129,116,37,163,99,142,187,249,134,77,217,298,29,127,174,115,122,178,12,80,122,76,16,41,115,84,104,121,127,40,287,129,9,172,112,51,40,135,205,53,259,196,248,5,123,184,209,130,271,42,18,143,24,101,10,273,252,50,173,80,119,129,45,257,299,78,278,78,190,215,284,129,200,232,103,97,167,120,49,298,141,146,154,233,214,196,244,50,110,48,152,82,226,26,254,276,292,286,215,56,128,122,82,241,222,12,272,192,224,136,116,70,39,207,295,49,194,90,210,123,271,18,276,87,177,240,276,33,155,200,51,6,212,36,149,202,48,114,58,91,83,221,175,148,278,300,284,86,191,95,77,215,113,257,153,135,217,76,85,269,126,194,199,195,20,204,194,50,220,228,90,221,256,87,157,246,74,156,9,196,16,259,234,79,31,206,148,12,223,151,96,229,165,9,144,26,255,201,33,89,145,155,1,204,37,107,80,212,88,186,254,9,158,180,24,45,158,100,52,131,71,174,229,236,296,299,184,168,41,45,76,68,122,85,292,238,293,179,143,128,47,87,267,53,187,76,292,0,160,70,172,292,9,64,156,153,26,145,196,222]
//[33,53,12,64,50,41,45,21,97,35,47,92,39,0,93,55,40,46,69,42,6,95,51,68,72,9,32,84,34,64,6,2,26,98,3,43,30,60,3,68,82,9,97,19,27,98,99,4,30,96,37,9,78,43,64,4,65,30,84,90,87,64,18,50,60,1,40,32,48,50,76,100,57,29,63,53,46,57,93,98,42,80,82,9,41,55,69,84,82,79,30,79,18,97,67,23,52,38,74,15]
//[33, 53, 12, 64, 50, 97, 35, 47, 39, 93, 55, 69, 42, 95, 51, 68, 9, 32, 6, 26, 3, 43, 30, 60, 3, 68, 9, 97, 19, 27, 4, 30, 9, 78, 43, 64, 4, 65, 30, 84, 64, 76, 57, 63, 53, 57, 42, 80, 9, 41, 30, 79, 18, 97, 67, 74, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
import java.util.Arrays;

//376. 摆动序列
public class L376 {

    @Test
    public void test() {
//        System.out.println(wiggleMaxLength(new int[]{33, 53, 12, 64, 50, 41, 45, 21, 97, 35, 47, 92, 39, 0, 93, 55, 40, 46, 69, 42, 6, 95, 51, 68, 72, 9, 32, 84, 34, 64, 6, 2, 26, 98, 3, 43, 30, 60, 3, 68, 82, 9, 97, 19, 27, 98, 99, 4, 30, 96, 37, 9, 78, 43, 64, 4, 65, 30, 84, 90, 87, 64, 18, 50, 60, 1, 40, 32, 48, 50, 76, 100, 57, 29, 63, 53, 46, 57, 93, 98, 42, 80, 82, 9, 41, 55, 69, 84, 82, 79, 30, 79, 18, 97, 67, 23, 52, 38, 74, 15}));
        int i = wiggleMaxLength(new int[]{1, 2,3,3,3,3,3,2,1});
        System.out.println(i);
    }

    //错误的
//    public static int wiggleMaxLength(int[] nums) {
//
//        int n = nums.length;
//        int[] dp = new int[n];
//        int count = 1;
//        dp[0] = nums[0];
//        int i;
//        for (i = 1; i < n; i++) {
//            if (nums[i - 1] != nums[i]) {
//                count++;
//                dp[1] = nums[i];
//                break;
//            }
//        }
//        if (count == 1) return 1;
//        for (i = i; i < n; i++) {
//            if (dp[count - 2] > dp[count - 1]) {
//                if (nums[i] > dp[count - 1]) {
//                    dp[count] = nums[i];
//                    count++;
//                }
//            } else if (dp[count - 2] < dp[count - 1]) {
//                if (nums[i] < dp[count - 1]) {
//                    dp[count] = nums[i];
//                    count++;
//                }
//            }
//        }
//        System.out.println(Arrays.toString(dp));
//        return count;
//    }

//    public static int wiggleMaxLength(int[] nums) {
//
//        int up = 1;
//        int down = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > nums[i - 1]) {
//                up = down + 1;
//            } else if (nums[i] < nums[i - 1]) {
//                down = up + 1;
//            }
//        }
//        return Math.max(up, down);
//    }

    //动态规划(最原始的)不懂
//    public int wiggleMaxLength(int[] nums) {
//        int n = nums.length;
//        if (n < 2) {
//            return n;
//        }
//        int[] up = new int[n];
//        int[] down = new int[n];
//        up[0] = down[0] = 1;
//        for (int i = 1; i < n; i++) {
//            if (nums[i] > nums[i - 1]) {
//                up[i] = Math.max(up[i - 1], down[i - 1] + 1);
//                down[i] = down[i - 1];
//            } else if (nums[i] < nums[i - 1]) {
//                up[i] = up[i - 1];
//                down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
//            } else {
//                up[i] = up[i - 1];
//                down[i] = down[i - 1];
//            }
//        }
//        System.out.println(Arrays.toString(up));
//        System.out.println(Arrays.toString(down));
//        return Math.max(up[n - 1], down[n - 1]);
//    }

    public static int wiggleMaxLength(int[] nums) {

        if (nums.length == 1) return 1;
        int[] result = new int[nums.length];
        int count = 1;
        result[0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1] || nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) {
                result[count++] = nums[i];
            }else if (nums[i] == nums[i-1] && nums[i]>result[count]||
                    nums[i] == nums[i-1] && nums[i]<result[count]){
                result[count++] = nums[i];
            }
        }
        if (nums[nums.length - 1] > result[count] || nums[nums.length - 1] < result[count]) {
            result[count++] = nums[nums.length - 1];
        }
        System.out.println(Arrays.toString(result));
        return count;
    }
}

