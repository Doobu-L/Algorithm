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

/*
  생각을 잘못하고있었다. 위의 방식으로 해결하려 할 경우, 312 , 31 -> 312222.compareTo(311111) 이 된다
  31312 > 31231 큼으로 31312(o) 지만 31231 이 나옴다.
  그럼 방법은 숫자를 채워주는 format을 333312 , 333331 처럼 앞을 채울 것인지 뒤를 채울 것인지를 결정해주는 구문이 들어가야 한다.
  이 방식으로 하면 코드도 길어지고 , 난해해 지기 때문에 다른 방법을 생각했다.
  
  앞+뒤 .compareTo 뒤+앞 이다.
  31231.compareTo 31312
  
  내림차순으로 정렬할 것으로 뒤+앞.compareTo 앞+뒤
  
*/

class Solution {

  public String solution(int[] numbers) {
    String answer = Arrays.stream(numbers).mapToObj(n->String.valueOf(n)).sorted((s, t1) -> t1.concat(s).compareTo(s.concat(t1))).collect(
        Collectors.joining());
    return answer.startsWith("0") ? "0":answer;
  }
}
