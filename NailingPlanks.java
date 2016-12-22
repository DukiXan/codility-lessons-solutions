package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Dudo on 21.12.2016.
 */
public class NailingPlanks {
    public int solution(int[] A, int[] B, int[] C) {
        ArrayList<Nail> nails = this.getArrayList(C);
        int max = -1;

        for (int i = 0; i < A.length; i++) {
            int current = this.getFirstNail(A[i], B[i], nails, max);
            if (current == -1) {
                return -1;
            }

            max = Math.max(max, current);
        }

        return max;
    }

    public ArrayList<Nail> getArrayList(int[] C) {
        ArrayList<Nail> nails = new ArrayList<>();

        for (int i = 0; i < C.length; i++) {
            nails.add(new Nail(C[i], i));
        }

        Collections.sort(nails);

        return nails;
    }

    public int getFirstNail(int A, int B, ArrayList<Nail> nails, int max) {
        int s = 0;
        int e = nails.size() - 1;
        int index = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int value = nails.get(mid).value;

            if (value < A) {
                s = mid + 1;
            } else if (value > B) {
                e = mid - 1;
            } else {
                e = mid - 1;
                index = mid;
            }
        }

        if (index == -1) {
            return -1;
        }

        Nail nail = nails.get(index);
        int min = nail.position;

        if (min < max) {
            return max;
        }

        for (int i = index + 1; i < nails.size(); i++) {
            Nail tempNail = nails.get(i);

            if (tempNail.value > B) {
                break;
            }

            if (tempNail.position < max) {
                return max;
            }

            min = Math.min(min, tempNail.position);
        }

        return min + 1;
    }
}

class Nail implements Comparable<Nail> {
    public int value;
    public int position;

    public Nail(int value, int position) {
        this.value = value;
        this.position = position;
    }

    @Override
    public int compareTo(Nail n) {
        int result = 0;
        if (this.value < n.value) {
            result = -1;
        } else if (this.value > n.value) {
            result = 1;
        }

        return result;
    }
}