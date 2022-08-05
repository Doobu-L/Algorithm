
// 고려해야 할 점. 
// 안입는 경우 포함 해야 함. getOrDefault에  0이 아니라 1이 들어가는 이유.
// 그래서 최종적으로 전부다 안입는 경우의 수를 제외해준다 . -1

class Solution {
  public int solution(String[][] clothes) {
    int answer = 1;
    Map<String,Integer> map = new HashMap<>();

    for(String[] cloth:clothes){
      map.put(cloth[1],map.getOrDefault(cloth[1],1)+1);
    }

    for(String s : map.keySet()){
      answer*=map.get(s);
    }

    return answer-1;
  }
}
