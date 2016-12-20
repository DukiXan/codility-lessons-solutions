package com.company;

/**
 * Created by Dudo on 13.12.2016.
 */
public class Ladder {
    public int[] solution(int[] A, int[] B) {
        int max = this.getMax(A);
        int[] fib = this.getFibArray(max);
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = fib[A[i]] & ((1 << B[i]) - 1);
        }

        return result;
    }

    public int getMax(int[] A) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }

        return max;
    }

    public int[] getFibArray(int max) {
        int[] fib = new int[max + 1];
        fib[0] = 1;
        fib[1] = 1;

        for (int i = 2; i <= max; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib;
    }
}
