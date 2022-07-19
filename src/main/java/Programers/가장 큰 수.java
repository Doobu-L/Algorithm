/*
  1~6 케이스 안됨, 60점짜리..ㅠㅠ
  
  풀이 방법 
  1. 0으로 이루어진 배열은 0을 리턴
  2. numbers -> List<num> class 로 변경
  3. num class에는 끝자리 숫자로 오른쪽 자릿수를 채우는 RPAD 와 비슷한 방식의 num.formaNUm 변수가 있음. ex) 232 -> 23222  - 조건1의 1~100000 참고.
  4. RPAD가 된 num.formatNum 을 key 값으로 comparing 후 reversed()
  5. joinning
  
*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<num> nums = Arrays.stream(numbers).mapToObj(num::new).collect(Collectors.toList());

        nums.sort(Comparator.comparing(num::getFormatNum).reversed());
        if(nums.get(0).n.equals("0"))return "0";

        return nums.stream().map(num::getN).collect(Collectors.joining());
    }
    
    class num{
    String n;
    String formatNum;

    public String getN(){
      return this.n;
    }

    public String getFormatNum(){
      return this.formatNum;
    }

    public num(int number){
      this.n = String.valueOf(number);
      StringBuffer sb = new StringBuffer();
      sb.append(this.n);
      for(int i=0;i<5-this.n.length();i++)sb.append(this.n.substring(this.n.length()-1));
      this.formatNum = sb.toString();
    }

  }
}
