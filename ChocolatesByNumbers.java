package com.company;

/**
 * Created by Dudo on 06.12.2016.
 */
public class ChocolatesByNumbers {
    public int solution(int N, int M) {
        return N / greatestCommonDivisor(N, M, 1);
    }

    public int greatestCommonDivisor(int N, int M, int c) {
        if (N == M) {
            return c * N;
        } else if (N % 2 == 0 && M % 2 == 0) {
            return greatestCommonDivisor(N / 2, M / 2, c * 2);
        } else if (N % 2 == 0) {
            return greatestCommonDivisor(N / 2, M, c);
        } else if (M % 2 == 0) {
            return greatestCommonDivisor(N, M / 2, c);
        } else if (N > M) {
            return greatestCommonDivisor(N - M, M, c);
        } else {
            return greatestCommonDivisor(N, M - N, c);
        }
    }
}
