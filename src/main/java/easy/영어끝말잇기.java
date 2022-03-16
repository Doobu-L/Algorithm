import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
		int[] answer = {0,0};
		Set<String> wordSet=new HashSet<>();
		wordSet.add(words[0]);
		for(int i=1;i<words.length;i++){
			if(!wordSet.add(words[i])){
				answer[0]=i%n+1;
				answer[1]=i/n+1;
				break;
			}
			if(!words[i].startsWith(words[i-1].substring(words[i-1].length()-1))){
				answer[0]=i%n+1;
				answer[1]=i/n+1;
				break;
			}
		}
		return answer;
	}
}
