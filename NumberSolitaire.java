package com.company;

/**
 * Created by Dudo on 30.12.2016.
 */
public class NumberSolitaire {
    public int solution(int[] A) {
        int[] result = new int[A.length];

        for (int i = 1; i < result.length; i++) {
            result[i] = Integer.MIN_VALUE;
        }

        result[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            for (int j = 1; j <= 6 && j <= i; j++) {
                result[i] = Math.max(A[i] + result[i - j], result[i]);
            }
        }

        return result[result.length - 1];
    }
}
