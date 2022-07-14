public int solution(int[] scoville, int K) {
    int answer = 0;

    PriorityQueue<Integer> scovileQue = new PriorityQueue<>();

    Arrays.stream(scoville).boxed().forEach(s -> scovileQue.add(s));

    int mix = 0;

    while(scovileQue.peek()<K){
      if(scovileQue.size() == 1) return -1;
      mix = scovileQue.poll() + (scovileQue.poll()*2);
      scovileQue.add(mix);
      answer++;
    }

    return answer;
  }
