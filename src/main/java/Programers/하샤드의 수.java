// x를 x자릿수 합으로 나누어 떨어지는 수. 12 => 12 % 1+2 ==0

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int num = x;
        int h = 0;

        while(num>0){
            h += num%10;
            num/=10;
        }
        if(x%h>0)answer=false;
        return answer;
    }
}

// 한줄로 뻥셔널하게 시도. 
// 아주 비효율 적이지만 보긴 이쁘다.

class Solution {
  public boolean solution(int x) {
    return x % Arrays.stream(String.valueOf(x).split("")).mapToInt(Integer::parseInt).sum() != 0;
  }
}
