package com.company;

/**
 * Created by Dudo on 18.10.2016.
 */
public class Brackets {
    public int solution(String S) {
        java.util.Stack<Character> stack = new java.util.Stack<Character>();

        for (int i = 0; i < S.length(); i++) {
            if (stack.empty() && this.isClosed(S.charAt(i))) {
                return 0;
            }

            if (this.isOpen(S.charAt(i))) {
                stack.push(S.charAt(i));
            } else if (this.isClosed(S.charAt(i))) {
                if (this.getType(S.charAt(i)) != -1 && (this.getType(S.charAt(i)) == this.getType(stack.peek()))) {
                    stack.pop();
                } else {
                    return 0;
                }
            }
        }

        return stack.empty() ? 1 : 0;
    }

    public boolean isOpen(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    public boolean isClosed(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    public int getType(char c) {
        int type = -1;
        if (c == '(' || c == ')') {
            type = 0;
        } else if (c == '{' || c == '}') {
            type = 1;
        } else if (c == '[' || c == ']') {
            type = 2;
        }

        return type;
    }
}
