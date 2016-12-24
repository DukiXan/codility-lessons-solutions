package com.company;

/**
 * Created by Dudo on 24.12.2016.
 */
public class MaxNonoverlappingSegments {
    public int solution(int[] A, int[] B) {
        int count = 0;
        int greaterThan = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > greaterThan) {
                count++;
                greaterThan = B[i];
            }
        }

        return count;
    }
}
