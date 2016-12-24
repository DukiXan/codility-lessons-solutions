package com.company;

/**
 * Created by Dudo on 24.12.2016.
 */
public class AbsDistinct {
    public int solution(int[] A) {
        java.util.Set set = new java.util.HashSet<Integer>();

        for (int i = 0; i < A.length; i++) {
            int temp = A[i] > 0 ? A[i] : A[i] * -1;
            set.add(temp);
        }

        return set.size();
    }
}
