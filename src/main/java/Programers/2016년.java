/*
  2016년은 윤년
  
  2016년 1월 1일은 금요일 FRI
  
  a월 b일의 요일을 출력
*/
class Solution {
    public String solution(int a, int b) {
    String[] dayOfWeek ={"FRI","SAT","SUN","MON","TUE","WED","THU"};
    int[] dayOfMonth={0,31,29,31,30,31,30,31,31,30,31,30,31};
    int days=0;
    for(int i=0;i<a;i++){
      days += dayOfMonth[i];
    }
    return dayOfWeek[(days+b-1)%7];
  }
}
