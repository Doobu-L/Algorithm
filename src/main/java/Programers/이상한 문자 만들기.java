// AbCdEf GhIjK LmNo
// 짝수 인덱스엔 대문자, 공백 이후 다시시작하는 문자열은 인덱스 0으로 초기화.

class Solution {
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for(String c:s.split("")){
			if(" ".equals(c)){
				idx=0;
				sb.append(" ");
				continue;
			}
			if(idx%2==0){
				sb.append(c.toUpperCase());
				idx++;
			}else{
				sb.append(c.toLowerCase());
				idx++;
			}
		}
		return sb.toString();
	}
}


// 코드 수를 줄여보았다. 

class Solution {
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		for(String c:s.split("")){
			sb.append(
					idx%2==0 ? c.toUpperCase() : c.toLowerCase()
			);
			idx = " ".equals(c) ? 0 : idx+1;
		}
		return sb.toString();
	}
}
