/*
  10 진법을 3진법으로 변환하는 문제인데 0 이 4로 치환되어야하고 4는 3의 역할을 하게된다.
  
  처음에 다양한 방법을 시도했다. 문제의 핵심을 파악하지못했고, 감기약 때문에 몽롱한 상태에서 너무 돌고 돌았다.
  
  stack에 나머지들을 집어넣고 하나씩 빼면서 0이면 4로바꿔주고 이전 값에 -1을 하는둥.... <- 전혀 필요없는 로직
  
  바람쐬며 환기하고 다시푸니 문제가 보였다.

*/

  public String solution2(int n) {
        String answer = "";

        while(n>0){
          int rest = n%3;
          n/=3;
          if(rest==0){
            rest = 4;
            n-=1;
          }
          answer = rest + answer;
        }

        return answer;
}

/*
  하지만 위 방식은 효율성을 통과하지 못했다.
  아무래도 불변객체 String의 특성상 값이 변하면서 메모리를 계속 잡아어서 그런가 싶어서 StringBuilder를 썼다. (동기화가 필요없기떄문에)
*/

  public String solution2(int n) {
        StringBuilder answer = new StringBuilder();

        while(n>0){
          int rest = n%3;
          n/=3;
          if(rest==0){
            rest = 4;
            n-=1;
          }
          answer.insert(0,rest);
        }

        return answer.toString();
      }
