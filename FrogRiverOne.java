package com.company;

import java.util.Set;
import java.util.HashSet;

/**
 * Created by Dudo on 12.10.2016.
 */
public class FrogRiverOne {
    public int solution(int X, int[] A) {
        if (A.length < 1) {
            return -1;
        }

        Set<Integer> set = new HashSet<Integer>();

        for (int i = 1; i <= X; i++) {
            set.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            set.remove(A[i]);
            if (set.isEmpty()) {
                return i;
            }
        }

        return -1;
    }
}
