package com.company;

/**
 * Created by Dudo on 22.10.2016.
 */
public class MaxDoubleSliceSum {
    public int solution(int[] A) {
        if (A.length < 4) {
            return 0;
        }

        int[] sum1 = new int[A.length];
        int[] sum2 = new int[A.length];

        for (int i = 1; i < A.length - 1; i++) {
            sum1[i] = Math.max(0, sum1[i - 1] + A[i]);
            sum2[A.length - 1 - i] = Math.max(0, sum2[A.length - i] + A[A.length - 1 - i]);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < A.length - 1; i++) {
            max = Math.max(max, sum1[i - 1] + sum2[i + 1]);
        }

        return max;
    }
}
