package com.company;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dudo on 12.10.2016.
 */
public class PermCheck{
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 1; i <= A.length; i++) {
            set.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            if (!set.contains(A[i])) {
                return 0;
            }

            set.remove(A[i]);
        }

        return set.isEmpty() ? 1 : 0;
    }
}
