/*
  효율성 0점 , 
  해설을 보니 조합 가능한 모든 info를 만들고, key - info / value - List<score> 를 만들어야 한다.
  그리고 이분탐색을 진행해서 빅오를 O(log n)으로 탐색해야한다.
  지금 코드는 O(n2)으로 효율성 최악인 코드
  
*/

public int[] solution2(String[] info, String[] query) {
    int[] answer = new int[query.length];
    for(int i=0;i<query.length;i++){
      String[] where = query[i].split(" ");
      for(String a:info){
        String[] aa= a.split(" ");
        if(!where[0].equals("-") && !where[0].equals(aa[0])) continue;
        if(!where[2].equals("-") && !where[2].equals(aa[1]) ) continue;
        if(!where[4].equals("-") && !where[4].equals(aa[2]) ) continue;
        if(!where[6].equals("-") && !where[6].equals(aa[3]) ) continue;
        if(Integer.parseInt(aa[4]) < Integer.parseInt(where[7]))continue;
        answer[i]++;
      }
    }
    return answer;
  }
