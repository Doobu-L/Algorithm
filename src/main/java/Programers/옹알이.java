package Programers;

import java.util.Arrays;
import java.util.List;

public class 옹알이 {
    private final List<String> AVAIL_BABBLING = List.of("aya", "ye", "woo", "ma");

    public int solution(String[] babbling) {
        return Math.toIntExact(Arrays.stream(babbling).filter(this::canBabbling).count());
    }

    private boolean canBabbling(String babbling) {
        for(String b: AVAIL_BABBLING){
            if(babbling.contains(b+b)) {
                return false;
            }
        }
        for(String b: AVAIL_BABBLING) {
            babbling = babbling.replaceAll(b, "-");
        }

        return babbling.replaceAll("-", "").isEmpty();
    }

    public static void main(String[] args) {
        옹알이 sol = new 옹알이();
        System.out.println("@@@@@@@@@ :: "+sol.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
    }
}
