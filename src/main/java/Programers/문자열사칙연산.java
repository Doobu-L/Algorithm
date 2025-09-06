package Programers;

import java.util.ArrayDeque;
import java.util.Deque;

public class 문자열사칙연산 {
    public int solution(String s) {

        Deque<String> numStack = new ArrayDeque<>();
        Deque<Character> opStack = new ArrayDeque<>();

        String temp = "";
        int tempNum = 0;

        for(Character ch : s.toCharArray()){
            if(isOperation(ch)) {
                //이전 연산 *,/ 확인후 연산
                if(!opStack.isEmpty() && isMultipleDivOp(opStack.peekLast())) {
                    tempNum = operation(Integer.parseInt(numStack.pollLast()), Integer.parseInt(temp), opStack.pollLast());
                    temp = String.valueOf(tempNum);
                }
                numStack.add(temp);
                opStack.add(ch);
                temp = "";
            } else {
                temp = temp + ch;
            }
        }

        if(!temp.isBlank()) {
            if(isMultipleDivOp(opStack.peekLast())) {
                tempNum = operation(Integer.parseInt(numStack.pollLast()), Integer.parseInt(temp), opStack.pollLast());
                temp = String.valueOf(tempNum);
            }
            numStack.add(temp);
        }

        tempNum = Integer.parseInt(numStack.poll());
        while(!numStack.isEmpty()){
            tempNum = operation(tempNum, Integer.parseInt(numStack.poll()), opStack.poll());
        }

        return tempNum;
    }

    private boolean isMultipleDivOp(Character ch){
        return ch.equals('*') || ch.equals('/');
    }

    private boolean isOperation(Character ch) {
        return ch.equals('+') || ch.equals('-') || this.isMultipleDivOp(ch);
    }


    private int operation(int num1, int num2, Character op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                throw new RuntimeException("Invalid Operation");
        }
    }

    public static void main(String[] args) {
        문자열사칙연산 sol = new 문자열사칙연산();
        System.out.printf("answer :: " + sol.solution("2-2*3"));
    }
}
