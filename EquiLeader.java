package com.company;

/**
 * Created by Dudo on 22.10.2016.
 */
public class EquiLeader {
    public int solution(int[] A) {
        int dominator = this.findDominator(A);
        int leftCounter = 0;
        int rightCounter = this.countAppearances(A, dominator);

        int counter = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == dominator) {
                leftCounter++;
                rightCounter--;
            }

            if ((double)leftCounter / (i + 1) > 0.5 &&
                    (double)rightCounter / (A.length - i - 1) > 0.5) {
                counter++;
            }
        }

        return counter;
    }

    public int countAppearances(int[] A, int n) {
        int counter = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == n) {
                counter++;
            }
        }

        return counter;
    }

    public int findDominator(int[] A) {
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();

        for (int i = 0; i < A.length; i++) {
            if (stack.empty() || stack.peek() == A[i]) {
                stack.push(A[i]);
            } else {
                stack.pop();
            }
        }

        boolean firstTime = true;
        int current = -1;
        int ret = -1;

        while (!stack.empty()) {
            if (!firstTime && current == stack.peek()) {
                stack.pop();
            } else {
                current = stack.pop();
                int counter = 0;
                for (int i = 0; i < A.length; i++) {
                    if (A[i] == current) {
                        counter++;
                        ret = current;
                    }
                }

                if (counter <= (double)(A.length / 2)) {
                    ret = -1;
                } else {
                    break;
                }
            }

            firstTime = false;
        }

        return ret;
    }
}
