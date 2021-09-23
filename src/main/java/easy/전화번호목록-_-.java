public static boolean solution(String[] phone_book) {
            boolean answer = true;
            for(String s : phone_book){
                for(String c:phone_book){
                    if(s.equals(c))continue;
                    if(s.startsWith(c))return false;
                }
            }
            return answer;
        }


//효율성 3,4 통과 못함.
