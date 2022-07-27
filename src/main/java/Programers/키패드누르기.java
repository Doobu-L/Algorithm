
/*
  키패드 
  
  1 2 3
  4 5 6
  7 8 9
  * 0 #
  
  1. number %3 ==1 ? 왼손엄지로 누른다
  2. number %3 ==0 ? 오른손엄지로 누른다
  3. number %3 ==2 ? 가운데 숫자패드들은 현재 오른손엄지와 왼손엄지 중 가까운 엄지로누른다.
  4. 두 엄지와 number %3 ==2 의 키의 거리가 같다면 주 손으로 누른다(hand)
  
  * -> 10
  0 -> 11
  # -> 12 로 계산
  
  
  
*/
class Solution {
  public String solution(int[] numbers, String hand) {
    String press = "";
    StringBuilder sb = new StringBuilder();
    int r = 12; //오른엄지 시작위치 #
    int l = 10; //왼엄지 시작위치 *

    for(int i=0;i<numbers.length;i++){
      press = touch(r,l,numbers[i],hand);
      sb.append(press);
      if("R".equals(press)){
        r=numbers[i]==0?11:numbers[i];
      }else{
        l=numbers[i]==0?11:numbers[i];
      }
    }

    return sb.toString();
  }

  String touch(int r, int l,int num,String hand){
    if(num==0)num=11;
    if(num%3==1)return"L";
    if(num%3==0)return"R";
    int disR =Math.abs(num-r)/3+Math.abs(num-r)%3; //현재 오른손 엄지와의 거리
    int disL =Math.abs(num-l)/3+Math.abs(num-l)%3; //현재 왼손 엄지와의 거리


    if( disR > disL)
      return "L";
    if(disR < disL)
      return "R";

    return "right".equals(hand)?"R":"L";
  }
}
