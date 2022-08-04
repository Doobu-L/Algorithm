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
