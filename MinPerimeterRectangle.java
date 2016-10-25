package com.company;

/**
 * Created by Dudo on 22.10.2016.
 */
public class MinPerimeterRectangle {
    public int solution(int N) {
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N / i; i++) {
            if (N % i == 0) {
                min = Math.min(min, 2 * (i + N / i));
            }
        }

        return min;
    }
}
