package com.company;

/**
 * Created by Dudo on 16.10.2016.
 */
public class Triangle {
    public int solution(int[] A) {
        java.util.Arrays.sort(A);

        int ret = 0;
        for (int i = 0; i < A.length - 2; i++) {
            if (this.isTriangle(A[i], A[i + 1], A[i + 2])) {
                ret = 1;
            }
        }

        return ret;
    }

    public boolean isTriangle(int a, int b, int c) {
        return (a > 0 && b > 0 && c > 0 && (a == b && b == c) || (a + b > c && a + c > b && b + c > a)) ? true : false;
    }
}
