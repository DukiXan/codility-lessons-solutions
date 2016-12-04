package com.company;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by Dudo on 04.12.2016.
 */
public class CountSemiprimes {
    public int[] solution(int N, int[] P, int[] Q) {
        HashSet<Integer> semiprimes = this.getSemiprimes(N);
        int[] prefixSum = this.getPrefixSum(semiprimes, N);
        int[] result = this.getRange(P, Q, prefixSum);

        return result;
    }

    public HashSet<Integer> getSemiprimes(int N) {
        boolean[] a = new boolean[N + 1];
        ArrayList<Integer> primes = new ArrayList<>();
        HashSet<Integer> semiprimes = new HashSet<>();

        for (int i = 2; i * i < N + 1; i++) {
            if (!a[i]) {
                for (int j = i * i; j < N + 1; j += i) {
                    a[j] = true;
                }
            }
        }

        for (int i = 2; i < N + 1; i++) {
            if (!a[i]) {
                primes.add(i);
                addSemiprimes(i, primes, semiprimes, N);
            }
        }

        return semiprimes;
    }

    public void addSemiprimes(int x, ArrayList<Integer> primes, HashSet<Integer> semiprimes, int N) {
        for (Integer prime : primes) {
            if (x * prime > N) {
                break;
            }
            semiprimes.add(prime * x);

            if (x <= prime) {
                break;
            }
        }
    }

    int[] getPrefixSum (HashSet<Integer> semiprimes, int N) {
        int[] prefixSum = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            if (semiprimes.contains(i)) {
                prefixSum[i] = 1;
            }
        }

        int sum = 0;

        for (int i = 0; i < N + 1; i++) {
            sum += prefixSum[i];
            prefixSum[i] = sum;
        }

        return prefixSum;
    }

    public int[] getRange(int[] P, int[] Q, int[] prefixSum) {
        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            result[i] = prefixSum[Q[i]] - prefixSum[P[i] - 1];
        }

        return result;
    }
}
