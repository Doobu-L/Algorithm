/*
  인수 n 은 10진수의 정수
  n을 3진법으로 만들고  ex)45 -> 1200
  만든 3진법을 뒤집고   1200->0021
  다시 10진법으로 만든다.  0021 -> 7
  
  선입후출이길래 스택을 썼다
*/

public int solution(int n) {
    int answer = 0;
    Stack<Integer> stack = new Stack<>();
    while(n>0){      
      stack.push(n%3);
      n/=3;
    }
    int x = 1;
    while(!stack.isEmpty()){
      answer += stack.pop() * x;
      x*=3;
    }
    return answer;
  }

/*
  다른 답안을 보니 Integer 의 parseInt 함수로 진법 설정을 할 수 있었다.
  Integer.parseInt((값),(진법))
  
  위 방법 이전에 StringBuilder 로 짰었는데, 코드가 너무 길고 오히려 가독성이 떨어져 보여서 
  코드를 수정 한 거긴 한데, 위 함수를 알고나니 코드가 더 짧아졌다.
*/

public int solution(int n) {
    StringBuilder sb = new StringBuilder();

    while(n>0){
      sb.append(n%3);
      n/=3;
    }
    return Integer.parseInt(sb.toString(),3);
  }


