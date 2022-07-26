import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

    int [] pattern1 = {1,2,3,4,5};
    int [] pattern2 = {2,1,2,3,2,4,2,5};
    int [] pattern3 = {3,3,1,1,2,2,4,4,5,5};

    int[] cnt=new int[3];
    int higtScore = 0;
    for(int i =0;i < answers.length;i++){
      if(answers[i] == pattern1[i%5])cnt[0]++;
      if(answers[i] == pattern2[i%8])cnt[1]++;
      if(answers[i] == pattern3[i%10])cnt[2]++;
    }

    for(int s:cnt)
      if(higtScore<s)
        higtScore=s;

    List<Integer> winner = new ArrayList<>();
    for(int i=0;i<3;i++)
      if(higtScore==cnt[i])
        winner.add(i+1);

    return winner.stream().mapToInt(Integer::intValue).toArray();
  }
}
