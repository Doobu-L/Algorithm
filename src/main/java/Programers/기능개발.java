import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    List<Integer> answer = new ArrayList<>();
    int day = 1;

    Queue<Integer> progressQ = new LinkedList<>();
    Arrays.stream(progresses).boxed().forEach(p ->progressQ.add(p));

    Queue<Integer> speedQ = new LinkedList<>();
    Arrays.stream(speeds).boxed().forEach(s ->speedQ.add(s));

    int progress = 0;
    int speed = 0;
    int ratio = 0;


    while(!progressQ.isEmpty()){
      progress = progressQ.peek();
      speed = speedQ.peek();
      ratio = progress + (speed*day);

      if(ratio >= 100){
        answer.set(answer.size()-1,answer.get(answer.size()-1)+1);
        progressQ.poll();
        speedQ.poll();
        continue;
      }else{
        if(answer.isEmpty() || answer.get(answer.size()-1)!=0) answer.add(0);
      }

      day++;
    }

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}
