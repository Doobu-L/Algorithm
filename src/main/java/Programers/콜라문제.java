package Programers;

public class 콜라문제 {
    public int solution(int a, int b, int n) {
        int answer = 0;

        while (n / a > 0) {
            answer += n / a * b;
            n = n / a * b + n % a;

        }

        return answer;
    }

    public static void main(String[] args) {
        콜라문제 sol = new 콜라문제();
        System.out.printf("정답 : "+sol.solution(2,1,20));
    }
}
