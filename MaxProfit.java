package com.company;

/**
 * Created by Dudo on 22.10.2016.
 */
public class MaxProfit {
    public int solution(int[] A) {
        if (A.length < 2) {
            return 0;
        }

        int currentMin = A[0];
        int max = 0;

        for (int i = 1; i < A.length; i++) {
            currentMin = Math.min(currentMin, A[i]);
            max = Math.max(A[i] - currentMin, max);
        }

        return max;
    }
}
