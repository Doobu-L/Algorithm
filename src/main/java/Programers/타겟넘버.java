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


//other case

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}
