package com.company;

/**
 * Created by Dudo on 12.10.2016.
 */
public class PassingCars {
    public int solution(int[] A) {
        int result = 0;
        int zeros = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                result += zeros;
            } else {
                zeros++;
            }

            if (result > 1000000000) {
                return -1;
            }
        }

        return result;
    }
}
