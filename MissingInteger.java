package com.company;

import java.util.Set;
import java.util.HashSet;

/**
 * Created by Dudo on 12.10.2016.
 */
public class MissingInteger {
    public int solution(int[] A) {
        if (A.length == 1 && A[0] != 1) {
            return 1;
        }

        Set<Integer> set = new HashSet<Integer>();

        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
            }

            set.add(A[i]);
        }

        if (max < 1) {
            return 1;
        }

        for (int i = 1; i < max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return max + 1;
    }
}
