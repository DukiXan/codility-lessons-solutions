package com.company;

/**
 * Created by Dudo on 22.10.2016.
 */
public class MaxProfit {
    public int solution(int[] A) {
        if (A.length < 2) {
            return 0;
        }

        int min = A[0];
        int ret = 0;

        for (int i = 0; i < A.length; i++) {
            min = Math.min(min, A[i]);
            int diff = A[i] - min;
            ret = diff > 0 ? Math.max(ret, diff) : Math.max(ret, 0);
        }

        return ret;
    }
}
