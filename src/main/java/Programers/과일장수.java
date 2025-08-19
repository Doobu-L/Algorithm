package Programers;

import java.util.Arrays;

public class 과일장수 {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        for(int i = score.length-m; i >= 0; i=i-m){
            answer += score[i] * m;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] score = {1, 2, 3, 4, 5,2,3,2};


        System.out.printf("" + Arrays.toString(score));
    }
}

