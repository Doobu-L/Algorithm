package Programers;

import java.util.Arrays;

public class 대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {

        return Arrays.stream(targets)
                .mapToInt(it -> checkPressKey(keymap, it))
                .toArray();
    }

    private int checkPressKey(String[] keymap, String target) {

        int totalPress = 0;
        int min = 101;
        int index = 0;
        for(String s : target.split("")) {
            min = 101;
            for(String key : keymap) {
                index = s.indexOf(key);
                if(index > 0)
                    min = Math.min(min,index+1);
            }
            if(min == 101)
                return -1;
            totalPress += min;
        }

        return totalPress;
    }

    public static void main(String[] args) {
        대충만든자판 sol = new 대충만든자판();
        int[] result = sol.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"});

        System.out.println("결과 ::: " + result);
    }
}
