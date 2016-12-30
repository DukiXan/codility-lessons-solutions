package com.company;

import java.util.HashMap;

/**
 * Created by Dudo on 30.12.2016.
 */
public class MinAbsSum {
    public int solution(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            A[i] = Math.abs(A[i]);
            sum += A[i];
        }

        sum /= 2;

        int[] subset = getSubsetSum(A, sum);
        HashMap<Integer, Integer> m = generateMap(subset);
        int result = generateResult(A, m);

        return result;
    }

    public int generateResult(int[] A, HashMap<Integer, Integer> m) {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < A.length; i++) {
            if (m.containsKey(A[i])) {
                m.put(A[i], m.get(A[i]) - 1);
                sum1 += A[i];

                if (m.get(A[i]) == 0) {
                    m.remove(A[i]);
                }
            } else {
                sum2 += A[i];
            }
        }

        return Math.abs(sum1 - sum2);
    }

    public int[] getSubsetSum(int[] A, int sum) {
        HashMap<Integer, Integer> times = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (times.containsKey(A[i])) {
                times.put(A[i], times.get(A[i]) + 1);
            } else {
                times.put(A[i], 1);
            }
        }

        int[] dynamic = new int[sum + 1];
        dynamic[0] = 0;

        for (int i = 1; i < dynamic.length; i++) {
            dynamic[i] = -1;
        }

        int[] numbers = new int[sum + 1];

        for (HashMap.Entry<Integer, Integer> entry : times.entrySet()) {
            for (int j = 0; j < sum + 1; j++) {
                if (dynamic[j] >= 0) {
                    dynamic[j] = entry.getValue();
                } else if (entry.getKey() <= j && dynamic[j - entry.getKey()] > 0) {
                    dynamic[j] = dynamic[j - entry.getKey()] - 1;
                    numbers[j] = entry.getKey();
                }
            }
        }

        return numbers;
    }

    public HashMap<Integer, Integer> generateMap(int[] numbers) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int i = numbers.length - 1;

        while (i > 0) {
            if (numbers[i] == 0) {
                i--;
            } else {
                break;
            }
        }

        while (i > 0) {
            if (!m.containsKey(numbers[i])) {
                m.put(numbers[i], 1);
            } else {
                m.put(numbers[i], m.get(numbers[i]) + 1);
            }

            i -= numbers[i];
        }

        return m;
    }
}
