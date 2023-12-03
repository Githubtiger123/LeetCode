package com.competition.java.C374;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//100144. 找出峰值
public class L100144 {


    @Test
    public void test() {

        System.out.println(findPeaks(new int[]{1, 4, 3, 8, 5}));
    }

    public List<Integer> findPeaks(int[] mountain) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {

            if (mountain[i] > mountain[i + 1] && mountain[i] > mountain[i - 1]) {
                list.add(i);
            }
        }
        return list;
    }
}
