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


/*
2 번째 도전 실패
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (5.31ms, 80.4MB)
테스트 2 〉	실패 (런타임 에러)
테스트 3 〉	실패 (런타임 에러)
테스트 4 〉	실패 (런타임 에러)
테스트 5 〉	통과 (17.91ms, 90.9MB)
테스트 6 〉	통과 (30.23ms, 89.9MB)
테스트 7 〉	실패 (런타임 에러)
테스트 8 〉	통과 (61.48ms, 105MB)
테스트 9 〉	통과 (69.91ms, 135MB)
테스트 10 〉	통과 (88.00ms, 114MB)
테스트 11 〉	통과 (18.06ms, 85MB)
테스트 12 〉	통과 (21.98ms, 98.9MB)
테스트 13 〉	실패 (런타임 에러)
테스트 14 〉	통과 (46.23ms, 113MB)
테스트 15 〉	통과 (44.67ms, 111MB)
테스트 16 〉	실패 (런타임 에러)
테스트 17 〉	통과 (31.01ms, 97.7MB)
테스트 18 〉	통과 (49.72ms, 111MB)
효율성  테스트
테스트 1 〉	통과 (1203.23ms, 312MB)
테스트 2 〉	통과 (1366.22ms, 321MB)
테스트 3 〉	통과 (1318.31ms, 289MB)
테스트 4 〉	통과 (1291.39ms, 275MB)
채점 결과
정확성: 26.7
효율성: 60.0
합계: 86.7 / 100.0
*/

public int[] solution2(String[] info, String[] query) {
    int[] answer = new int[query.length];
    Map<String,List<Integer>> allCase = new HashMap<>();

    for(String s:info){
      makeCase(s.split(" "),"",0,allCase);
    }

    allCase.keySet().stream().forEach(s -> allCase.get(s).sort(Integer::compareTo));

    for(int i=0;i<query.length;i++){
      String[] condition = query[i].replaceAll(" and ","").split(" ");
      List<Integer> scores = allCase.get(condition[0]);
      if(scores.isEmpty()){
        answer[i] = 0;
      }else{
        answer[i] = binarySearch(scores,Integer.parseInt(condition[1]));
      }
    }

    return answer;
  }

  void makeCase(String[] in,String text,int depth,Map<String,List<Integer>> allCase){
    if(depth==4){
      if(!allCase.containsKey(text)){
        List<Integer> scores = new ArrayList<>();
        scores.add(Integer.parseInt(in[depth]));
        allCase.put(text,scores);
      }else{
        allCase.get(text).add(Integer.parseInt(in[depth]));
      }
      return;
    }
    makeCase(in,text+in[depth],depth+1,allCase);
    makeCase(in,text+"-",depth+1,allCase);
  }
  
  int binarySearch(List<Integer> scores,int target){
    int left=0;
    int right=scores.size()-1;

    if(scores.get(right)<target){
      return 0;
    }
    while(left<right){
      int mid = (left+right)/2;
      if(scores.get(mid)<target){
        left = mid +1;
      }else {
        right = mid;
      }
    }

    return right;
  }

/*
   최종 답안.
   info[] - 1~10만건의 조건에 만건이상데이터에서 병렬처리가 유리했던 경험이 있어서 parallel() 사용.
          - 병렬처리 후 정렬도 해야하는데, 동기화에 유리하도록 순서를 보장하는 forEachOrdered() 사용.
          
   위 의 실패 케이스에서 런타임오류 발생한 케이스는 단순했다. 
   isEmpty() 초기화가 안된 컬렉션에서 함수를 호출하니 NullPointException이 났던 것 같다.
   if(scores.isEmpty()) 를
   if(scores == null ) 로 변경해줬고 , 런타임 오류 없이 잘 동작했다.
   
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] info, String[] query) {
    int[] answer = new int[query.length];
    Map<String,List<Integer>> allCase = new HashMap<>();

    Arrays.stream(info).parallel().forEachOrdered(s->makeCase(s.split(" "),"",0,allCase));
    
    allCase.keySet().stream().parallel().forEachOrdered(s -> allCase.get(s).sort(Integer::compareTo));  

    for(int i=0;i<query.length;i++){
      String[] condition = query[i].replaceAll(" and ","").split(" ");
      List<Integer> scores = allCase.get(condition[0]);
      if(scores==null){
        answer[i] = 0;
      }else{
        answer[i] = binarySearch(scores,Integer.parseInt(condition[1]));
      }
    }

    return answer;
  }

  void makeCase(String[] in,String text,int depth,Map<String,List<Integer>> allCase){
    if(depth==4){
      if(!allCase.containsKey(text)){
        List<Integer> scores = new ArrayList<>();
        scores.add(Integer.parseInt(in[depth]));
        allCase.put(text,scores);
      }else{
        allCase.get(text).add(Integer.parseInt(in[depth]));
      }
      return;
    }
    makeCase(in,text+in[depth],depth+1,allCase);
    makeCase(in,text+"-",depth+1,allCase);
  }

  int binarySearch(List<Integer> scores,int target){
    int left=0;
    int right=scores.size()-1;

      if(scores.get(right)<target){
      return 0;
    }
    
    while(left<right){
      int mid = (left+right)/2;
      if(scores.get(mid)<target){
        left = mid +1;
      }else {
        right = mid;
      }
    }

    return scores.size() - left;
  }
}
