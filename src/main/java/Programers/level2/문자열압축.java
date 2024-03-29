class Solution {
  public int solution(String s) {
    int answer = s.length();
    //문자열길이 ++
    for(int len=1;len<=s.length()/2;len++){
      StringBuilder sb = new StringBuilder();
      //문자열 압축
      for(int i=0;i<s.length();i+=len){
        int cnt = 1;
        //압축하다 남은 문자열 append
        if(i+len > s.length()){
          sb.append(s.substring(i));
          break;
        }
        String cur = s.substring(i,i+len);
        //압축 가능한 다음 문자열 카운트
        for(int j=i+len;j+len<=s.length();j+=len){
          if(cur.equals(s.substring(j,j+len))){
            cnt++;
            i=j;
          }else{
            break;
          }
        }
        if(cnt>1){
          sb.append(cnt+cur);
        }else{
          sb.append(cur);
        }
      }
      answer = Math.min(answer,sb.length());
    }
    return answer;
  }
}
