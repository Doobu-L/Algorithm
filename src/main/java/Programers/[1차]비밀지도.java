class Solution {
  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];
    for(int i=0;i<n;i++){
      StringBuilder sb = new StringBuilder();
      String s1 = formatNum(n,arr1[i]);
      String s2 = formatNum(n,arr2[i]);
      for(int j =0;j<n;j++){
        if(s1.charAt(j)=='0'&&s2.charAt(j)=='0'){
          sb.append(" ");
        }else{
          sb.append("#");
        }
      }
      answer[i] = sb.toString();
    }
    return answer;
  }

  String formatNum(int n,int num){
    StringBuilder s = new StringBuilder();
    s.append(Integer.toString(num,2));
    while(s.length()<n){
      s.insert(0,"0");
    }
    return s.toString();
  }
}
