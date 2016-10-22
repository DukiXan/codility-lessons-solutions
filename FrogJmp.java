package com.company;

/**
 * Created by Dudo on 12.10.2016.
 */
public class FrogJmp {
    public int solution(int X, int Y, int D) {
        return (Y - X) % D != 0 ? (Y - X) / D + 1: (Y - X) / D;
    }
}
