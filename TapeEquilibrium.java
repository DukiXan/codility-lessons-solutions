package com.company;

/**
 * Created by Dudo on 12.10.2016.
 */
public class TapeEquilibrium {
    public int solution(int A[]) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < A.length; i++) {
            right += A[i];
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            left += A[i];
            right -= A[i];

            int diff = Math.abs(left - right);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }
}
