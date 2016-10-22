package com.company;

/**
 * Created by Dudo on 15.10.2016.
 */
public class CountDiv {
    public int solution(int A, int B, int K) {
        int result = -1;

        if (A == 0) {
            result = B / K - A / K + 1;
        } else {
            result = B / K - (A - 1) / K;
        }

        return result;
    }
}
