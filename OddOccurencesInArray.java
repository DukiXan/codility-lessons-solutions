package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dudo on 11.10.2016.
 */
public class OddOccurencesInArray {
    public int solution(int[] A) {
        if (A == null || A.length < 1) {
            return -1;
        }

        Map<Integer, Integer> occurences = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            int key = A[i];

            if (occurences.containsKey(key)) {
                int temp = occurences.get(key);
                temp++;
                occurences.put(key, temp);
            } else {
                occurences.put(key, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : occurences.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
