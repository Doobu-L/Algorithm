
class Solution {
  public int[] solution(String[] id_list, String[] report, int k) {
    int[] answer = new int[id_list.length];
    Map<String, Set<String>> reportMap = new HashMap<>();
    Map<String, Integer> resultMap = new HashMap<>();

    for(String r:report){
      String id = r.split(" ")[0];
      String rep = r.split(" ")[1];
      if(reportMap.containsKey(id)){
        if(reportMap.get(id).contains(rep))
          continue;
        reportMap.get(id).add(rep);
      }else{
        Set<String> reported = new HashSet<>();
        reported.add(rep);
        reportMap.put(id,reported);
      }

      resultMap.put(rep,resultMap.getOrDefault(rep,0)+1);
    }

    for(int i=0;i<id_list.length;i++){
      if(reportMap.containsKey(id_list[i])){
        for(String reportedUser:reportMap.get(id_list[i])){
          if(resultMap.get(reportedUser)>=k)
            answer[i]++;
        }
      }else{
        answer[i]=0;
      }
    }

    return answer;
  }
}
