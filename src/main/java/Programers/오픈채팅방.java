
class Solution {
  public String[] solution(String[] record) {
    List<String> answer = new ArrayList<>();

    Map<String,String> userMap = new HashMap<>();
    String inOut ="";
    String uid = "";
    String nickname = "";
    for(String re:record){
      inOut = re.split(" ")[0];
      if("Leave".equals(inOut)) continue;
      uid = re.split(" ")[1];
      nickname = re.split(" ")[2];

      if("Change".equals(inOut)){
        userMap.replace(uid,nickname);
      }else if(userMap.containsKey(uid)){
        userMap.replace(uid,nickname);
      }else{
        userMap.put(uid,nickname);
      }
    }

    for(String re:record){
      inOut = re.split(" ")[0];
      uid = re.split(" ")[1];
      if("Change".equals(inOut)){
        continue;
      }else if("Enter".equals(inOut)){
        answer.add(userMap.get(uid)+"님이 들어왔습니다.");
      }else if("Leave".equals(inOut)){
        answer.add(userMap.get(uid)+"님이 나갔습니다.");
      }
    }
    return answer.toArray(new String[answer.size()]);
  }
}
