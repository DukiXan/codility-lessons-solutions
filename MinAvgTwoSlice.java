package com.company;

/**
 * Created by Dudo on 15.10.2016.
 */
public class MinAvgTwoSlice {
    private double globalMin = Integer.MAX_VALUE;
    private int globalMinIndex = Integer.MAX_VALUE;

    public int solution(int[] A) {
        this.getMin(A, 2);
        this.getMin(A, 3);

        return this.globalMinIndex;
    }

    public void getMin(int[] A, int p) {
        for (int i = 0; i < A.length - (p - 1); i++) {
            double avg = (double)this.sum(A, i, p) / p;
            if (avg < this.globalMin) {
                this.globalMin = avg;
                this.globalMinIndex = i;
            }
        }
    }

    public int sum(int[] A, int i, int p) {
        int sum = 0;

        for (int k = i; k < i + p; k++) {
            sum += A[k];
        }

        return sum;
    }
}
