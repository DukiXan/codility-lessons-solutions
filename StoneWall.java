package com.company;

/**
 * Created by Dudo on 19.10.2016.
 */
public class StoneWall {
    public int solution(int[] H) {
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        int count = 0;

        for (int i = 0; i < H.length; i++) {
            if (stack.empty()) {
                stack.push(H[i]);
                count++;
            } else if (stack.peek() > H[i]) {
                stack.pop();
                i--;
            } else if (stack.peek() < H[i]) {
                stack.push(H[i]);
                count++;
            }
        }

        return count;
    }
}
