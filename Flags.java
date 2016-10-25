package com.company;

/**
 * Created by Dudo on 23.10.2016.
 */
public class Flags {
    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int[] next = this.generateNextArray(A);
        if (next[0] == -1) {
            return 0;
        }

        for (int i = (int)Math.sqrt(A.length) + 1; i > 0; i--) {
            if (this.isValid(next, i)) {
                return i;
            }
        }

        return 0;
    }

    public int[] generateNextArray(int[] A) {
        int[] next = new int[A.length];
        next[A.length - 1] = -1;
        for (int i = A.length - 2; i >= 1; i--) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                next[i] = i;
            } else {
                next[i] = next[i + 1];
            }
        }

        next[0] = next[1];

        return next;
    }

    public boolean isValid(int[] next, int x) {
        int lastPeak = next[0];
        int nextPeak = next[0];
        int count = 0;

        while (true) {
            nextPeak = next[nextPeak + 1];

            if (nextPeak - lastPeak >= x) {
                count++;
                lastPeak = nextPeak;
            }

            if (nextPeak == -1) {
                count++;
                break;
            }
        }

        return count >= x;
    }
}
