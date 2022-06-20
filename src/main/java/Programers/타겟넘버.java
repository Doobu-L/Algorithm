import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int solution(int[] numbers, int target) {
        AtomicInteger answer = new AtomicInteger(0);
        dfs(numbers,0,0,target,answer);
        return answer.get();
    }
    public void dfs(int[] nums,int depth,int result,int target,AtomicInteger cnt){
		if(nums.length == depth){
			if(result==target){
				cnt.getAndIncrement();
			}
		}else{
			dfs(nums,depth+1,result+nums[depth],target,cnt);
			dfs(nums,depth+1,result-nums[depth],target,cnt);
		}
	}
}
