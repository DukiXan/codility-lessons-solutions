package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dudo on 04.12.2016.
 */
public class CountNonDivisible {
    public int[] solution (int[] A) {
        HashMap<Integer, Integer> map = this.getMap(A);
        HashMap<Integer, Integer> divs = this.getDivs(map);
        int[] result = this.getResult(divs, A);

        return result;
    }

    public int[] getResult(HashMap<Integer, Integer> divs, int[] A) {
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = A.length - divs.get(A[i]);
        }

        return result;
    }

    public HashMap<Integer, Integer> getMap(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 0);
            }

            map.put(A[i], map.get(A[i]) + 1);
        }

        return map;
    }

    public HashMap<Integer, Integer> getDivs(HashMap<Integer, Integer> map) {
        HashMap<Integer, Integer> divs = new HashMap<>();

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int N = e.getKey();
            int current = 0;

            for (int i = 1; i <= N / i; i++) {
                if (N % i == 0) {
                    current += (map.containsKey(i) ? map.get(i) : 0);

                    if (!(i * i == N)) {
                        current += (map.containsKey(N / i) ? map.get(N / i) : 0);
                    }
                }
            }

            divs.put(N, current);
        }

        return divs;
    }
}
