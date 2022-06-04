
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

//다른이들 풀이. distinct를 사용해서 같은 유저를 여러번 신고하는 걸 걸러내고
//람다표현식을 활용해 문제를 해결하는 방법이 인상깊엇다.
class Solution2 {
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : list) {
            String target = s.split(" ")[1];
            count.put(target, count.getOrDefault(target, 0) + 1);
        }

        return Arrays.stream(id_list).map(_user -> {
            final String user = _user;
            List<String> reportList = list.stream().filter(s -> s.startsWith(user + " ")).collect(Collectors.toList());
            return reportList.stream().filter(s -> count.getOrDefault(s.split(" ")[1], 0) >= k).count();
        }).mapToInt(Long::intValue).toArray();
    }
}


//OOP, 쉬운 난이도의 문제지만 실무에서는 거의 Entity나 Dto를 활용해서 결과를 만들어 내기 때문에
//이런식의 방식으로 풀려는 노력을 항상 해야 할 것 같다.
class Solution3 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        ArrayList<User> users = new ArrayList<>();
        HashMap<String,Integer> suspendedList = new HashMap<>(); //<이름>
        HashMap<String,Integer> idIdx = new HashMap<String,Integer>(); // <이름, 해당 이름의 User 클래스 idx>
        int idx = 0;

        for(String name : id_list) {
            idIdx.put(name,idx++);
            users.add(new User(name));
        }

        for(String re : report){
            String[] str = re.split(" ");
            //suspendedCount.put(str[0], suspendedCount.getOrDefault(str[0],0)+1);
            users.get( idIdx.get(str[0])).reportList.add(str[1]);
            users.get( idIdx.get(str[1])).reportedList.add(str[0]);
        }

        for(User user : users){
            if(user.reportedList.size() >= k)
                suspendedList.put(user.name,1);
        }

         for(User user : users){
             for(String nameReport : user.reportList){
                 if(suspendedList.get(nameReport) != null){
                     answer[idIdx.get(user.name)]++;
                 }

             }
        }




        return answer;
    }
}

class User{
    String name;
    HashSet<String> reportList;
    HashSet<String> reportedList;
    public User(String name){
        this.name = name;
        reportList = new HashSet<>();
        reportedList = new HashSet<>();
    }
}


