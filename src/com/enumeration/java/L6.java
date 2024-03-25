package com.enumeration.java;

import org.junit.Test;

import java.util.ArrayList;

//6. Z 字形变换
public class L6 {


    public String convert1(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        int n = s.length();
        char[][] arr = new char[numRows][n];
        char[] chars = s.toCharArray();
        boolean b = false;
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if (y < 0) {
                y = 1;
                x--;
                b = false;
            }

            if (y >= numRows) {

                y = numRows - 2;
                x++;
                b = true;
            }
//            System.out.println("x:" + x + ",y:" + y);
            if (b) {
                arr[y--][x++] = chars[i];
            } else {
                arr[y++][x] = chars[i];
            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int yy = 0; yy < numRows; yy++) {
            for (int xx = 0; xx < n; xx++) {
                if (arr[yy][xx] == 0) {
                    continue;
                }
                stringBuilder.append(arr[yy][xx]);
            }
        }
        return stringBuilder.toString();
    }

    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean b = false;
        int y = 0;
        for (int i = 0; i < n; i++) {
            if (y < 0) {
                y = 1;
                b = false;
            }

            if (y >= numRows) {

                y = numRows - 2;
                b = true;
            }
            if (b) {
                list.get(y).append(chars[i]);
                y--;
            } else {
                list.get(y).append(chars[i]);
                y++;
            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }

    @Test
    public void test() {

        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("P", 10));
    }
}
