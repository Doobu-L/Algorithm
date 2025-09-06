package Programers;

import java.util.Arrays;
import java.util.Stack;

/**
 * 첫 풀이에서 이중포문으로 풀어서 시간초과 발생. 91점
 * refactor : 스택 활용하여 뒤에부터 채우는 방식으로 변경.
 *            스택에는 현재 비교하는 숫자보다 큰 가장 가까운 숫자가 저장되어있음. peek()으로 확인.
 * */

public class 뒤에있는큰수 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer,-1);
        Stack<Integer> st = new Stack<Integer>();

        for(int i = numbers.length-1; i >= 0 ; i--) {
            while(!st.isEmpty() && numbers[st.peek()] <= numbers[i]) {
                st.pop();
            }

            if(!st.isEmpty()) {
                answer[i] = numbers[st.peek()];
            }

            st.push(i);
        }

        return answer;
    }
}
