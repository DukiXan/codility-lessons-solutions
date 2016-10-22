package com.company;

/**
 * Created by Dudo on 22.10.2016.
 */
public class MaxSliceSum {
    public int solution(int[] A) {
        int current = 0;
        int max = Integer.MIN_VALUE;
        int numberOfNegativeNumbers = 0;
        int maxNegativeNumber = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                numberOfNegativeNumbers++;
                if (A[i] > maxNegativeNumber) {
                    maxNegativeNumber = A[i];
                }
            }

            current = Math.max(0, current + A[i]);
            max = Math.max(max, current);
        }

        return numberOfNegativeNumbers == A.length ? maxNegativeNumber : max;
    }
}
