import java.util.Set;
import java.util.HashSet;

class Solution {
  static Set<Integer> primes = new HashSet<>();

  public int solution(String numbers) {
    String[] numberArr = numbers.split("");

    for(int i=0;i<numberArr.length;i++){
      dfs(numberArr[i],numberArr,i,null);
    }

    return primes.size();
  }

  void dfs(String curNum,String[] numberArr,int idx,boolean[] visited){
    if(curNum.length()>numberArr.length)return;
    if(!primes.contains(curNum)){
      if(isPrime(curNum)){
        primes.add(Integer.parseInt(curNum));
      }
    }
    for(int i=0;i<numberArr.length;i++){
      boolean[] newVisited=  visited;
      if(visited==null){
        newVisited = new boolean[numberArr.length];
      }
      newVisited[idx]=true;
      if(!newVisited[i]){
        dfs(curNum+numberArr[i],numberArr,i,newVisited);
      }
    }
  }

  boolean isPrime(String curNum){
    int num = Integer.parseInt(curNum);
      if(num<2)return false;
    for(int i=2;i<=Math.sqrt(num);i++){
       if(num%i==0)return false;
    }
    return true;
  }
}



class Solution {

  static Set<Integer> primes = new HashSet<>();

  public int solution(String numbers) {
    reclusive("",numbers);
    return primes.size();
  }

  boolean isPrime(String curNum) {
    int num = Integer.parseInt(curNum);

    if (primes.contains(curNum))
      return true;
    if (num < 2)
      return false;
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0)
        return false;
    }
    primes.add(num);
    return true;
  }

  void reclusive(String cur, String others) {
    if(!"".equals(cur))
      isPrime(cur);

    for (int i = 0; i < others.length(); i++) {
      reclusive(cur + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
    }
  }
}
