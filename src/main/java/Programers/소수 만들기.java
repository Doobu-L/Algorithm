import java.util.HashSet;
import java.util.Set;

class Solution {
  Set<Integer> primeSet  = new HashSet();
  public int solution(int[] nums) {
    int answer = 0 ;
    for(int i=0;i<nums.length-2;i++){
      for(int k=i+1;k<nums.length-1;k++) {
        for (int j = k+1; j < nums.length; j++) {
          if (isPrime(nums[i]+nums[k]+nums[j]))answer++;
        }
      }
    }
    return answer;
  }

  boolean isPrime(int num){
    if(primeSet.contains(num)){
      return true;
    }else{
      for(int i=2;i<=Math.sqrt(num);i++){
        if(num%i==0)return false;
      }
      primeSet.add(num);
      return true;
    }
  }
}
