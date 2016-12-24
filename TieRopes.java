package com.company;

/**
 * Created by Dudo on 24.12.2016.
 */
public class TieRopes {
    public int solution(int K, int[] A) {
        int count = 0;
        int current = 0;

        for (int i = 0; i < A.length; i++) {
            current += A[i];

            if (current >= K) {
                count++;
                current = 0;
            }
        }

        return count;
    }
}
