package com.company;

public class Main {

    public static void main(String[] args) {
        Peaks solution = new Peaks();
        int[] s =  {1, 2, 1, 2, 1, 2, 1, 2, 1};
        int answer = solution.solution(s);
        System.out.println(answer);
    }
}
