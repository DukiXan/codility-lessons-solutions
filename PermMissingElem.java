package com.company;

/**
 * Created by Dudo on 12.10.2016.
 */
public class PermMissingElem {
    int solution(int A[]) {
        if (A.length < 1) {
            return 1;
        }

        int sum = 2 * A.length + 1;
        for (int i = 0; i < A.length; i++) {
            sum += i - A[i];
        }

        return sum;
    }
}
