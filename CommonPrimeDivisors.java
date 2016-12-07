package com.company;

/**
 * Created by Dudo on 07.12.2016.
 */
public class CommonPrimeDivisors {
    public int solution(int[] A, int[] B) {
        int count = 0;

        for (int i = 0; i < A.length; i++) {
            int gcd = gcd(A[i], B[i]);

            if (gcdFurther(A[i], gcd) == 1 && gcdFurther(B[i], gcd) == 1) {
                count++;
            }
        }

        return count;
    }

    public int gcdFurther(int a, int gcd) {
        while (gcd != 1) {
            a /= gcd;
            gcd = gcd(gcd, a);
        }

        return a;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
