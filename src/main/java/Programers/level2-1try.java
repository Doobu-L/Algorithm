/*
문제 설명
길이가 같은 배열 A, B 두개가 있습니다. 각 배열은 자연수로 이루어져 있습니다.
배열 A, B에서 각각 한 개의 숫자를 뽑아 두 수를 곱합니다. 이러한 과정을 배열의 길이만큼 반복하며, 두 수를 곱한 값을 누적하여 더합니다. 이때 최종적으로 누적된 값이 최소가 되도록 만드는 것이 목표입니다. (단, 각 배열에서 k번째 숫자를 뽑았다면 다음에 k번째 숫자는 다시 뽑을 수 없습니다.)

예를 들어 A = [1, 4, 2] , B = [5, 4, 4] 라면

A에서 첫번째 숫자인 1, B에서 첫번째 숫자인 5를 뽑아 곱하여 더합니다. (누적된 값 : 0 + 5(1x5) = 5)
A에서 두번째 숫자인 4, B에서 세번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 5 + 16(4x4) = 21)
A에서 세번째 숫자인 2, B에서 두번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 21 + 8(2x4) = 29)
즉, 이 경우가 최소가 되므로 29를 return 합니다.

배열 A, B가 주어질 때 최종적으로 누적된 최솟값을 return 하는 solution 함수를 완성해 주세요.

제한사항
배열 A, B의 크기 : 1,000 이하의 자연수
배열 A, B의 원소의 크기 : 1,000 이하의 자연수
입출력 예
A	B	answer
[1, 4, 2]	[5, 4, 4]	29
[1,2]	[3,4]	10
입출력 예 설명
입출력 예 #1
문제의 예시와 같습니다.

입출력 예 #2
A에서 첫번째 숫자인 1, B에서 두번째 숫자인 4를 뽑아 곱하여 더합니다. (누적된 값 : 4) 다음, A에서 두번째 숫자인 2, B에서 첫번째 숫자인 3을 뽑아 곱하여 더합니다. (누적된 값 : 4 + 6 = 10)
이 경우가 최소이므로 10을 return 합니다.
*/
import java.util.Arrays;
import java.util.Comparator;

class Solution
{
    public int solution(int []A, int []B)
    {
    int answer = 0;
    Integer[] a = Arrays.stream(A).sorted().boxed().toArray(Integer[]::new);
    Integer[] b = Arrays.stream(B).sorted().boxed().toArray(Integer[]::new);

    for(int i=0;i<A.length;i++){
      answer+=a[i]*b[A.length-1-i];
    }

    return answer;
  }
}

//정확성 34.8 , 효율성 0



/*
  효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
(1칸, 1칸, 1칸, 1칸)
(1칸, 2칸, 1칸)
(1칸, 1칸, 2칸)
(2칸, 1칸, 1칸)
(2칸, 2칸)
의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요. 예를 들어 4가 입력된다면, 5를 return하면 됩니다.

제한 사항
n은 1 이상, 2000 이하인 정수입니다.
입출력 예
n	result
4	5
3	3
입출력 예 설명
입출력 예 #1
위에서 설명한 내용과 같습니다.

입출력 예 #2
(2칸, 1칸)
(1칸, 2칸)
(1칸, 1칸, 1칸)
총 3가지 방법으로 멀리 뛸 수 있습니다.

*/

import java.util.concurrent.atomic.AtomicLong;

class Solution {
    public long solution(int n) {
        AtomicLong answer = new AtomicLong(0);

        dsp(1,n,answer);
        dsp(2,n,answer);

        return answer.get();
    }
    void dsp(int now,int n ,AtomicLong count){
        if(now>n){
          return;
        }else if(now==n){
          count.getAndIncrement();
          return;
        }else{
          dsp(now+1,n,count);
          dsp(now+2,n,count);
        }
  }
}

//정확성 12.5 효율성 0

//문제 다시파악 - 1,2,3,5,8,13....  dp[i] = dp[i-1]+dp[i-2]
class Solution {
  public long solution(int n) {
      int[] dp = new int[n];
      dp[1] = 1;
      dp[2] = 2;
      for(int i=3; i<n; i++){
          dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
      }
      return dp[n];
  }
}


