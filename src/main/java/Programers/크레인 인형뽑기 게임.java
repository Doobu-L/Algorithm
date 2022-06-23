public class Test{
  public static void main(String[] args) {
      Solution solution = new Solution();

      int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
      int[] moves = {1,5,3,5,1,2,1,4};
      System.out.printf(""+solution.solution(board,moves));
    }
}
class Solution {
  public int solution(int[][] board, int[] moves) {
    AtomicInteger answer = new AtomicInteger();
    Stack<Integer> tray = new Stack<>();
    Arrays.stream(moves).forEach(move ->{
      int doll = pull(move-1,0,board);
      if(doll != 0) pushTray(doll, tray, answer);
    });

    return answer.get();
    }

  int pull(int move,int depth,int[][] board){
    if(depth == board.length) return 0;
    int doll = board[depth][move];
    if(doll != 0){
      board[depth][move] = 0;
      return doll;
    }
    return pull(move,depth+1,board);
  }

  void pushTray(int doll,Stack<Integer> tray,AtomicInteger answer){
    if(!tray.isEmpty()) {
      if(tray.peek().compareTo(doll)==0){
        tray.pop();
        answer.set(answer.addAndGet(2));
        return;
      }
    }
    tray.push(doll);
  }
}
