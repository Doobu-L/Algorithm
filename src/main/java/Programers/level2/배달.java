//시간초과

class Solution {
  public int solution(int N, int[][] road, int K) {
    int answer = 0;
    
    //배달 가능한 지점
    boolean[] avail = new boolean[N+1];

    //이차원 배열에 n지점에서 m지점까지 소요시간 저장.
    int[][] cost = new int[N+1][N+1];

    //cost 양방향 저장.
    for(int[] c:road){
      if(cost[c[0]][c[1]]>0){
        cost[c[0]][c[1]] = Math.min(cost[c[0]][c[1]],c[2]);
        cost[c[1]][c[0]] = Math.min(cost[c[1]][c[0]],c[2]);
      }else{
        cost[c[0]][c[1]]=c[2];
        cost[c[1]][c[0]]=c[2];
      }

    }

    dfs(1,0,cost,K,avail);

    for(boolean b:avail)
      if(b)
        answer++;
    return answer;
  }

  //cur = 현재 위치, sum = 소요시간, cost = 소요시간표, k = K, avail = 배달가능지점
  void dfs(int cur,int sum,int[][] cost,int k,boolean[] avail){
    if(k<sum){
      return;
    }
    avail[cur]=true;
    for(int i=1;i<cost.length;i++){
      if(cost[cur][i] != 0){
        dfs(i,sum+cost[cur][i],cost,k,avail);
      }
    }
  }
}


//dfs 부분만 수정, 바로 전 위치로 돌아가지 못하도록 pre 인자 추가.
//32번만 시간초과...
void dfs(int cur,int sum,int[][] cost,int k,boolean[] avail,int pre){
    if(k<sum){
      return;
    }
    avail[cur]=true;
    for(int i=2;i<cost.length;i++){
      if(i==pre)continue;
      if(cost[cur][i] != 0){
        dfs(i,sum+cost[cur][i],cost,k,avail,cur);
      }
    }
  }


//다른 블로그를 참고해서 플로이드 와샬 알고리즘을 이용해서 풀었다.
//플로이드 와샬 알고리즘은 2차원 배열을 최소 소요시간으로 채우는 알고리즘이다. int[A][B] map A거점 -> B거점 / map[1][2] = 1->2로가는 최소 소요시간
import java.util.Arrays;

class Solution {
    public int solution(int N, int[][] road, int K) {
    int answer = 0;

    int[][] floyedMatrix = new int[N+1][N+1];
    
    for(int[] f:floyedMatrix){
      //처음에 5000000 이 아니라 Integer.Maxvalue 를 썼는데 , 계속 더하니 -값이 되어서 계속 틀렸다.
      //INF 값을 주던지, 문제에서 정해준 최대 값을 넣어주어야 함.
      Arrays.fill(f,5000000);
    }
    
    //자기 자신은 소요시간 0
    for(int i=0;i<=N;i++){
      floyedMatrix[i][i]=0;
    }
    
    //인자값으로 받은 소요시간 배열인 road를 이용해 floyMatrix를 채워준다.
    for(int[] cost:road){
      floyedMatrix[cost[0]][cost[1]] = Math.min(cost[2],floyedMatrix[cost[0]][cost[1]]);
      floyedMatrix[cost[1]][cost[0]] = Math.min(cost[2],floyedMatrix[cost[1]][cost[0]]);
    }
    
    //i를 경유해서 j -> k로 가는 최소비용 계산
    for(int i=1;i<=N;i++)
      for(int j=1;j<=N;j++)
        for(int k=1;k<=N;k++)
          floyedMatrix[j][k] = Math.min(floyedMatrix[j][k],floyedMatrix[j][i]+floyedMatrix[i][k]);
      
   //여기까지 오면 floyedMatrix는 모든거점->모든거점 최소 소요시간으로 가득 채운 이차원 배열이 된다.
        
   for(int i=1;i<=N;i++){ 
     if(floyedMatrix[1][i]<=K)
       answer++;
   }

    return answer;
  }
}

