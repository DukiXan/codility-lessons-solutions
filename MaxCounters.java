package com.company;

/**
 * Created by Dudo on 12.10.2016.
 */
public class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        int currentMax = 0;
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                currentMax = max;
            } else {
                if (counters[A[i] - 1] < currentMax) {
                    counters[A[i] - 1] = currentMax;
                }

                counters[A[i] - 1]++;

                if (counters[A[i] - 1] > max) {
                    max = counters[A[i] - 1];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (counters[i] < currentMax) {
                counters[i] = currentMax;
            }
        }

        return counters;
    }
}
