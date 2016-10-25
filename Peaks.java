package com.company;

/**
 * Created by Dudo on 25.10.2016.
 */
public class Peaks {
    public int solution(int[] A) {
        if (A.length < 3) {
            return 0;
        }

        int[] prefixSum = this.generatePrefixSum(A);

        for (int i = (A.length - 1) / 2; i > 0; i--) {
            if (A.length % i == 0 && this.validNumberOfBlocks(i, prefixSum)) {
                return i;
            }
        }

        return 0;
    }

    public boolean validNumberOfBlocks(int blocks, int[] prefixSum) {
        int itemsPerBlock = prefixSum.length / blocks;
        int lastIndex = 0;

        for (int i = itemsPerBlock - 1; i < prefixSum.length; i += itemsPerBlock) {
            if (prefixSum[i] - prefixSum[lastIndex] <= 0) {
                return false;
            }

            lastIndex = i;
        }

        return true;
    }

    public int[] generatePrefixSum(int[] A) {
        int[] prefixSum = new int[A.length];
        prefixSum[0] = 0;

        for (int i = 1; i < A.length - 1; i++) {
            int current = A[i] > A[i - 1] && A[i] > A[i + 1] ? 1 : 0;
            prefixSum[i] = prefixSum[i - 1] + current;
        }

        prefixSum[A.length - 1] = prefixSum[A.length - 2];

        return prefixSum;
    }
}
