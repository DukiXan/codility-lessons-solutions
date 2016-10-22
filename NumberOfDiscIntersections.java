package com.company;

/**
 * Created by Dudo on 17.10.2016.
 */
public class NumberOfDiscIntersections {
    public int solution(int[] A) {
        int[] S = this.createArray(A, "start");
        int[] E = this.createArray(A, "end");

        java.util.Arrays.sort(S);
        java.util.Arrays.sort(E);

        int[] timeline = new int[2 * A.length];
        int sIndex = 0;
        int eIndex = 0;

        for (int i = 0; i < timeline.length; i++) {
            if (sIndex >= A.length || E[eIndex] < S[sIndex]) {
                timeline[i] = -1;
                eIndex++;
            } else {
                timeline[i] = 1;
                sIndex++;
            }
        }

        int active = 0;
        int sum = 0;

        for (int i = 0; i < timeline.length; i++) {
            active += timeline[i];
            if (timeline[i] == 1) {
                sum += active - 1;
                if (sum > 10000000) {
                    return -1;
                }
            }
        }

        return sum;
    }

    public int[] createArray(int[] A, String s) {
        int[] ret = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            if (Integer.MAX_VALUE - i <= A[i]) {
                ret[i] = (s.equals("start")) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                continue;
            }

            ret[i] = (s.equals("start")) ? i - A[i] : i + A[i];
        }

        return ret;
    }
}
