package Programers;

public class 지폐접기 {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while(!isBillFittable(wallet,bill)) {
            foldBill(bill);
            answer++;
        }

        return answer;
    }

    private void foldBill(int[] bill) {
        if(bill[0] > bill[1]) {
            bill[0] /= 2;
        } else {
            bill[1] /= 2;
        }
    }

    private boolean isBillFittable(int[] wallet, int[] bill) {
        if(wallet[0] >= bill[0] && wallet[1] >= bill[1])
            return true;

        if(wallet[0] >= bill[1] && wallet[1] >= bill[0])
            return true;

        return false;
    }


    public static void main(String[] args) {
        지폐접기 sol = new 지폐접기();
        sol.solution(new int[]{30,15}, new int[]{26,17});
    }
}

