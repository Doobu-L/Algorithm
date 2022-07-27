/*
  약수의 개수가 짝수면 빼고
  약수의 개수가 홀수면 더한 합.
*/
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;i++){
            if(cnt(i)%2==0){
                answer-=i;
            }else{
                answer+=i;
            }
            
        }
        return answer;
    }
  
    int cnt(int num){
        int cnt=0;
        for(int i=1;i<=num/2;i++){
            if(num%i==0){
                cnt++;
            }
        }
        return cnt;
    }
}

