package com.enumeration.java;

public class L641 {


}

class MyCircularDeque {

    private int capacity;
    private int size;
    private int[] deque;
    private int start, end;

    public MyCircularDeque(int k) {

        capacity = k;
        size = 0;
        deque = new int[k];
        start = end = 0;
    }

    public boolean insertFront(int value) {

        if (isFull()) {
            return false;
        } else {

            if (isEmpty()) {
                start = end = 0;
                deque[end] = value;
            } else {
                start = start == 0 ? capacity - 1 : start - 1;
                deque[start] = value;
            }
            size++;
            return true;
        }
    }

    public boolean insertLast(int value) {

        if (isFull()) {
            return false;
        } else {

            if (isEmpty()) {
                start = end = 0;
                deque[end] = value;
            } else {
                end = end == capacity - 1 ? 0 : end + 1;
                deque[end] = value;
            }
            size++;
            return true;
        }
    }

    public boolean deleteFront() {

        if (isEmpty()) {
            return false;
        } else {
            if (size == 1) {
                start = end = 0;
            } else {
                start = start == capacity - 1 ? 0 : start + 1;
            }
            size--;
            return true;
        }
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        } else {
            if (size == 1) {
                start = end = 0;
            } else {
                end = end == 0 ? capacity - 1 : end - 1;
            }
            size--;
            return true;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        } else {
            return start < 0 ? deque[capacity + start] : deque[start];
        }
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        } else {
            return end >= capacity ? deque[end - capacity] : deque[end];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
