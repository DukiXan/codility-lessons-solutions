package com.company;

/**
 * Created by Dudo on 15.10.2016.
 */
public class Distinct {
    public int solution(int[] A) {
        if (A.length < 2) {
            return A.length;
        }

        int distinct = 1;
        this.quicksort(A, 0, A.length - 1);

        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                distinct++;
            }
        }

        return distinct;
    }

    public void quicksort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }

        int p = partition(A, start, end);
        this.quicksort(A, start, p - 1);
        this.quicksort(A, p + 1, end);
    }

    public int partition(int[] A, int start, int end) {
        int pivot = A[end];
        int p = start;

        for (int i = start; i < end; i++) {
            if (A[i] < pivot) {
                this.swap(A, i, p);
                p++;
            }
        }

        this.swap(A, p, end);

        return p;
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
