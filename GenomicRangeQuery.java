package com.company;

/**
 * Created by Dudo on 15.10.2016.
 */
public class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        int[][] sums = this.createSums(S);
        int[] ret = this.getMinimalValues(S, P, Q, sums);

        return ret;
    }

    public int[] getMinimalValues(String S, int[] P, int[] Q, int[][] sums) {
        int[] ret = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (P[i] == 0 && sums[j][Q[i]] > 0 || P[i] != 0 && (sums[j][Q[i]] - sums[j][P[i] - 1] > 0)) {
                    ret[i] = j + 1;
                    break;
                }
            }
        }

        return ret;
    }

    public int[][] createSums(String S) {
        int[][] sums = new int[4][S.length()];

        for (int i = 0; i < 4; i++) {
            int tempValue = this.getValue(S.charAt(0));
            if (tempValue == i + 1) {
                sums[i][0] = 1;
            } else {
                sums[i][0] = 0;
            }
        }

        for (int i = 1; i < S.length(); i++) {
            for (int j = 0; j < 4; j++) {
                sums[j][i] = sums[j][i - 1];
                int tempValue = this.getValue(S.charAt(i));

                if (tempValue == j + 1) {
                    sums[j][i]++;
                }
            }
        }

        return sums;
    }

    public int getValue(char c) {
        int value = -1;

        if (c == 'A') {
            value = 1;
        } else if (c == 'C') {
            value = 2;
        } else if (c == 'G') {
            value = 3;
        } else {
            value = 4;
        }

        return value;
    }
}
