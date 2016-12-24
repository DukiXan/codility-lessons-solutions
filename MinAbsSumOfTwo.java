package com.company;

/**
 * Created by Dudo on 24.12.2016.
 */
public class MinAbsSumOfTwo {
    public int solution(int[] A) {
        java.util.Arrays.sort(A);

        boolean allPositive = true;
        boolean allNegative = true;
        boolean hasZero = false;

        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                allPositive = false;
            } else if (A[i] > 0) {
                allNegative = false;
            } else if (A[i] == 0) {
                hasZero = true;
            }
        }

        int result = 0;

        if (hasZero) {
            result = 0;
        } else if (allPositive) {
            result = A[0] + A[0];
        } else if (allNegative) {
            result = Math.abs(A[A.length - 1] + A[A.length - 1]);
        } else {
            result = this.getMin(A);
        }

        return result;
    }

    public int getMin(int[] A) {
        int s = 0;
        int e = A.length - 1;
        int min = Integer.MAX_VALUE;

        while (s <= e) {
            min = Math.min(min, Math.abs(A[s] + A[e]));

            if (Math.abs(A[s]) > Math.abs(A[e])) {
                s++;
            } else {
                e--;
            }
        }

        return min;
    }
}
