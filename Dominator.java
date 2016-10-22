package com.company;

/**
 * Created by Dudo on 22.10.2016.
 */
public class Dominator {
    public int solution(int[] A) {
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
                        ret = i;
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
