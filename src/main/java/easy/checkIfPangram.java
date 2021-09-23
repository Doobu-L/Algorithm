class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26) return false;
        //97~122
        String[] alpabet = "abcdefghijklmnopqrstuvwxyz".split("");
        for(int i = 0;i<alpabet.length;i++){
            if(sentence.contains(alpabet[i]))continue;
            if(!sentence.contains(alpabet[i])) return false;
        };
        return true;
    }
}


//최소 하나이상의 알파벳을 포함하는 문장 검증.
