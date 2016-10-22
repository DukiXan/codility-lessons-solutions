package com.company;

/**
 * Created by Dudo on 18.10.2016.
 */
public class Nesting {
    public int solution(String S) {
        int counter = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                counter++;
            } else if (S.charAt(i) == ')') {
                counter--;
            }

            if (counter < 0) {
                return 0;
            }
        }

        return counter == 0 ? 1 : 0;
    }
}
