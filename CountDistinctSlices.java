package com.company;

/**
 * Created by Dudo on 24.12.2016.
 */
public class CountDistinctSlices {
    public int solution(int M, int[] A) {
        java.util.Set<Integer> set = new java.util.HashSet<>();
        int count = 0;
        int j = 0;

        for (int i = 0; i < A.length; i++) {
            for (; j < A.length && !set.contains(A[j]); j++) {
                set.add(A[j]);
            }
            count += j - i;

            if (count > 1000000000) {
                return 1000000000;
            }

            set.remove(A[i]);
        }

        return count;
    }
}
