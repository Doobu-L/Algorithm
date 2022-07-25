import java.util.Set;
import java.util.HashSet;

class Solution {
  static Set<Integer> primes = new HashSet<>();

  public int solution(String numbers) {
    String[] numberArr = numbers.split("");

    for(int i=0;i<numberArr.length;i++){
      bfs(numberArr[i],numberArr,i,null);
    }

    return primes.size();
  }

  void bfs(String curNum,String[] numberArr,int idx,boolean[] visited){
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
        bfs(curNum+numberArr[i],numberArr,i,newVisited);
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
