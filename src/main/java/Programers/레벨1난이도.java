
class Solution {
  //프로그래머스 - 체육복
  public int solution(int n, int[] lost, int[] reserve) {
    Arrays.sort(reserve);
    Set<Integer> set = Arrays.stream(lost).boxed().collect(Collectors.toSet());

    for(int i=0;i<reserve.length;i++)
      if(set.remove(reserve[i]))
        reserve[i]=32;


    for(int i=0;i<reserve.length;i++){
      if(set.contains(reserve[i]-1)){
        set.remove(reserve[i]-1);
        continue;
      }else if(set.contains(reserve[i]+1)){
        set.remove(reserve[i]+1);
        continue;
      }
    }

    return n- set.size();
  }

  //프로그래머스 - 없는 수의 합
  public int solution2(int[] numbers) {
    return 45 - Arrays.stream(numbers).sum();
  }

  //프로그래머스 - 음양의 합
  public int solution3(int[] absolutes, boolean[] signs) {
    int answer = 0;
    for(int i=0;i<absolutes.length;i++){
      answer+=absolutes[i]*(signs[i]?1:-1);
    }

    return answer;
  }

  //프로그래머스 = 포켓몬
  public int solution4(int[] nums) {
    int answer = 0;
    HashSet set = (HashSet) Arrays.stream(nums).boxed().collect(Collectors.toSet());

    return nums.length/2 > set.size() ? set.size() : nums.length;

  }
}
