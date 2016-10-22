package com.company;

/**
 * Created by Dudo on 15.10.2016.
 */
public class MaxProductOfThree {
    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        java.util.Arrays.sort(A);

        int res1 = A[A.length - 1] * A[A.length - 2] * A[A.length - 3];
        int res2 = A[0] * A[1] * A[A.length - 1];
        int res3 = A[0] * A[A.length - 1] * A[A.length - 2];
        int res4 = A[0] * A[1] * A[2];

        return Math.max(res4, Math.max(res1, Math.max(res2, res3)));
    }
}
