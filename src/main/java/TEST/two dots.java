// 백준 two dots 랑 비슷하지만 변형문제. 이건 1,2,3,4 의 값이 있음.
//    int answer = sol.solution4( new int[][] {{4, 2, 3,2}, {2,1,2,4}, {1,2,3,1}, {4,1,4,3}});
class Point {
    int x;
    int y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "[" +
              "" + x +
              ", " + y +
              ']';
    }
  }

  public int solution4(int[][] board) {
    int answer=-1;
    
    Queue<List<Point>> nodes = new LinkedList<>();
    for(int i=0;i<board.length;i++) {
      for(int j=0;j<board[i].length; j++) {
        nodes.add(Collections.singletonList(new Point(i, j)));
      }
    }

    while (!nodes.isEmpty()) {
      List<Point> visited = nodes.poll();

      // 계산
      answer = visited.size() != 0 ? Math.max(answer, visited.size()) : answer;

      Point point = visited.get(visited.size()-1);
      int target = board[point.x][point.y];

      System.out.println(visited);

      // 방문할 다음 포인트를 체크하고, 추가한다. (+-1)
      if (canVisit(point.x-1, point.y, board, target, visited)) {
        List<Point> newVisited = new ArrayList<>(visited);
        newVisited.add(new Point(point.x-1, point.y));
        nodes.add(newVisited);
      } else if (canVisit(point.x+1, point.y, board, target, visited)) {
        List<Point> newVisited = new ArrayList<>(visited);
        newVisited.add(new Point(point.x+1, point.y));
        nodes.add(newVisited);
      } else if (canVisit(point.x, point.y-1, board, target, visited)) {
        List<Point> newVisited = new ArrayList<>(visited);
        newVisited.add(new Point(point.x, point.y - 1));
        nodes.add(newVisited);
      } else if (canVisit(point.x, point.y+1, board, target, visited)) {
        List<Point> newVisited = new ArrayList<>(visited);
        newVisited.add(new Point(point.x, point.y + 1));
        nodes.add(newVisited);
      }
    }

    return answer;
  }

  public boolean canVisit(int x, int y, int[][] board, int target, List<Point> visited) {
    if(x < 0 || x >= board.length) return false;
    if(y < 0 || y >= board.length) return false;
    if(target != board[x][y]) return false;
    return visited.stream().noneMatch(p -> p.x == x && p.y == y);
  }
