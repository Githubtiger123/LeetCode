package com.enumeration.java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

//50. Pow(x, n)
public class L50 {

    public double myPow(double x, int n) {

        if (n != 0 && x == 0) {
            return 0;
        }

        if (n == 0 && x == 0) {
            throw new ArithmeticException("0's negative power is undetermined");
        }

        boolean flag = n > 0;
        long b = Math.abs((long) n);//这里很坑,一定要加(long)要不然就溢出了
        double ans = 1;
        double a = x;
        while (b > 0) {

            if ((b & 1) == 1) {
                ans *= a;
            }
            a *= a; //特别注意
            b >>= 1;
        }
        return flag ? ans : 1.0 / ans;
    }

    @Test
    public void test() {
        System.out.println(myPow(2.0, -2147483648));
    }
}
