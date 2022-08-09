//주어진 number 에서 k 개수 만큼 제거한 숫자 중 가장 큰 수 
//앞에서부터 차례대로 제거. 순서는 보장되어야함.
//첫 포문은 return 하려는 글자 수만큼 돈다
//두번 째 포문은 idx ~ i+k 사이에 가장 큰 수를 읽어서 idx 와 max 를 도출한다.

class Solution {
  public String solution(String number, int k) {

    StringBuilder sb = new StringBuilder();

    int max = 0;
    int idx = 0;
    for(int i=0;i<number.length()-k;i++){
      max = 0;
      for(int j=idx;j<=i+k;j++){
        if(max < number.charAt(j)-'0'){
          max = number.charAt(j)-'0';
          idx = j+1;
        }
      }
      sb.append(max);
    }

    return sb.toString();
  }
}
