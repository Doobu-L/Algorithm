package Programers;

public class 문자열나누기 {
    public int solution(String s) {
        int answer = 0;

        char first = s.charAt(0);
        int firstCnt = 0;
        int otherCnt = 0;

        for(int curIndex = 0; curIndex < s.length() ; curIndex++){
            if(firstCnt == 0) {
                first = s.charAt(curIndex);
                firstCnt++;
                continue;
            }

            if(s.charAt(curIndex) == first) {
                firstCnt++;
            } else {
                otherCnt++;
            }

            if(firstCnt == otherCnt) {
                answer++;
                firstCnt=0;
                otherCnt=0;
            }
        }

        if(firstCnt != 0)
            answer++;
        return answer;
    }

    public static void main(String[] args) {
        문자열나누기 sol = new 문자열나누기();
        int result = sol.solution("banana");

        System.out.println("결과 ::: " + result);
    }
}
