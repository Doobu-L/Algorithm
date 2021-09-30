class Solution {
    public int balancedStringSplit(String s) {
      int count =0 ;
      int balance = 0;

      String[] arr = s.split("");
      for(String w : arr){
        if(w.equals("R"))balance+=1;
        if(w.equals("L"))balance-=1;
        if(balance==0) count++;
      }

      return count;
    }
  
  
  //개선
  
  class Solution {
    public int balancedStringSplit(String s) {
        int c=0;
        int rc=0;
        int lc=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='R')
            {
                rc++;
            }
            if(s.charAt(i)=='L'){
                lc++;
            }
            if(rc==lc){
                c++;
            }
        }
        return c;
    }
}
