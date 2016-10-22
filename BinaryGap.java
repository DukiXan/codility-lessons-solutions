package com.company;

/**
 * Created by Dudo on 11.10.2016.
 */
public class BinaryGap {
    public int solution(int N) {
        String n = this.getBinaryString(N);
        int currentCounter = 0;
        int maxCounter = 0;
        boolean startCounting = false;

        for (int i = n.length() - 1; i >= 0; i--) {
            if (n.charAt(i) == '1') {
               startCounting = true;
            }

            if (n.charAt(i) == '0' && startCounting) {
                currentCounter++;
            } else {
                currentCounter = 0;
            }

            if (currentCounter > maxCounter) {
                maxCounter = currentCounter;
            }
        }

        return maxCounter;
    }

    public String getBinaryString(int n) {
        if (n < 0) {
            n *= -1;
        }

        if (n < 2) {
            return "1";
        }

        return this.getBinaryString(n / 2) + Integer.toString(n % 2);
    }
}
