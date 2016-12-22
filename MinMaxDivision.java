package com.company;

/**
 * Created by Dudo on 21.12.2016.
 */
public class MinMaxDivision {
    public int solution(int K, int M, int[] A) {
        int min = 0;
        int max = A.length * M;
        int result = 0;

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (this.validNumberOfSections(mid, A, K)) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return result;
    }

    public boolean validNumberOfSections(int x, int[] A, int k) {
        int current = 0;
        int sections = 1;

        for (int i = 0; i < A.length; i++) {
            if (current + A[i] <= x) {
                current += A[i];
            } else if (A[i] <= x) {
                sections++;
                current = A[i];
            } else {
                return false;
            }

            if (sections > k) {
                return false;
            }
        }

        return true;
    }
}
