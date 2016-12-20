package com.company;

import java.util.ArrayList;

/**
 * Created by Dudo on 20.12.2016.
 */
public class FibFrog {
    public int solution(int[] A) {
        ArrayList<Integer> fib = this.getAllFib(A.length);

        if (fib.contains(A.length + 1)) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        int[] steps = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                steps[i] = getMinSteps(steps, fib, i);
            }

            if (fib.contains(A.length - i) && steps[i] > 0) {
                min = Math.min(min, steps[i] + 1);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int getMinSteps(int[] steps, ArrayList<Integer> fib, int x) {
        if (fib.contains(x + 1)) {
            return 1;
        }

        int min = Integer.MAX_VALUE;

        for (Integer i : fib) {
            if (x > i && steps[x - i] > 0) {
                min = Math.min(min, steps[x - i] + 1);
            }

            if (x <= i) {
                break;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public ArrayList<Integer> getAllFib(int n) {
        int a = 1;
        int b = 2;
        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(a);
        fib.add(b);

        while(true) {
            b = a + b;
            a = b - a;
            fib.add(b);

            if (b >= n + 1) {
                break;
            }

        }

        return fib;
    }
}
