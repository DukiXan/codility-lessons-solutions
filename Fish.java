package com.company;

/**
 * Created by Dudo on 19.10.2016.
 */
public class Fish {
    public int solution(int[] A, int[] B) {
        if (A.length != B.length || A.length < 1 || B.length < 1) {
            return 0;
        }

        java.util.Stack<SingleFish> stack = new java.util.Stack<SingleFish>();
        int alive = A.length;

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 0 && !stack.empty()) {
                if (stack.peek().size < A[i]) {
                    stack.pop();
                    i--;
                }
                alive--;
            } else if (B[i] == 1){
                stack.push(new SingleFish(A[i], B[i]));
            }
        }

        return alive;
    }
}

class SingleFish {
    public int size;
    public int direction;

    public SingleFish (int size, int direction) {
        this.size = size;
        this.direction = direction;
    }
}
