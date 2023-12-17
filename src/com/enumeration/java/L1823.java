package com.enumeration.java;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//1823. 找出游戏的获胜者
public class L1823 {

    @Test
    public void test() {

        System.out.println(findTheWinner(5, 2));
    }

    public int findTheWinner(int n, int k) {

        Queue<Integer> queue = new LinkedList();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() != 1) {

            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
//        return queue.poll();
        return queue.peek();//返回队列的头部元素，但不移除该元素，如果队列为空则返回null。
    }

    public int findTheWinner1(int n, int k) {

        int ans = 0, count = n, temp = k, i = 0;
        int[] arr = new int[n];
        while (count != 1) {

            if (i == n) {
                i = 0;
            }

            if (arr[i] == -1) {
                i++;
                continue;
            }
            if (temp == 1) {
                arr[i] = -1;
                count--;
                temp = k + 1;
            }
            temp--;
            i++;
        }
        for (int j = 0; j < n; j++) {
            if (arr[j] == 0) {
                ans = j;
                break;
            }
        }
        return ans + 1;
    }
}
