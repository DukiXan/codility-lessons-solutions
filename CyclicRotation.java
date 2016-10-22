package com.company;

/**
 * Created by Dudo on 12.10.2016.
 */
public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        if (A == null || A.length < 1) {
            return new int[0];
        }

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[(i + K) % A.length] = A[i];
        }

        return result;
    }
}
