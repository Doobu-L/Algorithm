
class Solution {
	public int[] solution(int N, int[] stages) {
		int[] answer = {};
		List<stage> allStage = new ArrayList<>();
		for(int i=1;i<=N;i++){
			allStage.add(new stage(i,stages));
		}

		return allStage.stream()
      .sorted(Comparator.comparing(stage::getFailRatio,Comparator.reverseOrder()))
      .mapToInt(stage::getStage)
      .toArray();
	}
}
class stage{
	int stage;
	int players;
	int failPlayers;
	Double failRatio;

	public stage(int stage,int[] stages){
		this.stage = stage;
		for(int s:stages){
			if(stage<=s)
				this.players++;
			if(stage==s)
				this.failPlayers++;
		}
		this.failRatio = (double) failPlayers/ (double) players;
		if(this.failRatio.isNaN()) 
      this.failRatio=(double)0;
	}
	public double getFailRatio(){
		return this.failRatio;
	}
	public int getStage(){
		return this.stage;
	}
}
