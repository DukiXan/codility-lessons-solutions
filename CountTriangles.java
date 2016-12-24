package com.company;

/**
 * Created by Dudo on 24.12.2016.
 */
public class CountTriangles {
    public int solution(int[] A) {
        java.util.Arrays.sort(A);
        int result = 0;

        for (int i = 0; i < A.length - 2; i++) {
            int k = i + 2;

            for (int j = i + 1; j < A.length - 1; j++) {
                for (; k < A.length && this.valid(A[i], A[j], A[k]); k++);
                result += k - j - 1;
            }
        }

        return result;
    }

    public boolean valid(int i, int j, int k) {
        return i + j > k && i + k > j && k + j > i;
    }
}
