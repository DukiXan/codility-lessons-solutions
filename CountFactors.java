package com.company;

/**
 * Created by Dudo on 22.10.2016.
 */
public class CountFactors {
    public int solution(int N) {
        if (N == 1) {
            return 1;
        }

        int counter = 2;
        int i = 2;

        for (; i < N / i; i++) {
            if (N % i == 0) {
                counter += 2;
            }
        }

        if (i * i == N) {
            counter++;
        }

        return counter;
    }
}
