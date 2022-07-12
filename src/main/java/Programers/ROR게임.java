
// BFS - QUEUE

class Solution {
  public int solution(int[][] maps) {
    int answer = 10000;
    boolean[][] visited = new boolean[maps.length][maps[0].length];
    Queue<Node> que = new LinkedList<>();
    que.add(new Node(0,0,1));

    while(!que.isEmpty()){

      Node node = que.poll();

      if(node.x == maps.length-1 && node.y == maps[0].length-1){
        answer = Math.min(answer,node.cnt);
        continue;
      }

      addNode(new Node(node.x+1, node.y, node.cnt+1),maps,visited,que);
      addNode(new Node(node.x-1, node.y, node.cnt+1),maps,visited,que);
      addNode(new Node(node.x, node.y+1, node.cnt+1),maps,visited,que);
      addNode(new Node(node.x, node.y-1, node.cnt+1),maps,visited,que);

    }
    return answer == 10000? -1 : answer;
  }

  boolean check(Node node, int[][] maps, boolean[][] visited){
    if(node.x<0 || node.y <0 || node.x >= maps.length || node.y >= maps[0].length
        || maps[node.x][node.y]==0 || visited[node.x][node.y] ) return false;
    return true;
  }

  void addNode(Node node, int[][] maps,boolean[][] visited, Queue<Node> que){
    if(check(node,maps,visited)){
      que.add(node);
      visited[node.x][node.y]=true;
    }
  }


  class Node{
    int x;
    int y;
    int cnt;

    public Node(int x, int y, int cnt){
      this.x = x;
      this.y = y;
      this.cnt = cnt;
    }
  }
}
