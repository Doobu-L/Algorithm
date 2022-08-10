//보트 = 최대 2명
// 2명 <= limit
// [] people -> 몸무게 배열.

class Solution {
  public int solution(int[] people, int limit) {
    int answer = 0;
    Arrays.sort(people);

    int max=people.length -1;
    for(int min=0;min<max+1;min++){
      while(min<=max){
        if(min==max){
          answer++;
          break;
        }
        if(people[min]+people[max]>limit){
          answer++;
          max--;
          continue;
        }else{
          answer++;
          max--;
          break;
        }
      }
    }

    return answer;
  }
}


// 난.. 모든 경우를 카운트 할 생각만 했다. 아래 케이스는 2명이 짝된 케이스를 전체 인원수에서 뺀 로직...짝짝짝짝!!
import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        for (; i < j; --j) {
            if (people[i] + people[j] <= limit)
                ++i;
        }
        return people.length - i;
    }
}
