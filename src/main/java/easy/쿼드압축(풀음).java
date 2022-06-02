class Solution {
  public int[] solution(int[][] arr) {
    int[] answer = {0,0};
    int size = arr.length;
    zip(0,0,arr,size,answer);

    return answer;
  }

  private void zip(int curX,int curY,int[][] arr, int size, int[] answer) {
    if(check(curX,curY,size,arr)){
      answer[arr[curX][curY]]++;
      return;
    }
    zip(curX,curY,arr,size/2,answer);
    zip(curX+size/2,curY,arr,size/2,answer);
    zip(curX,curY+size/2,arr,size/2,answer);
    zip(curX+size/2,curY+size/2,arr,size/2,answer);
  }

  private boolean check(int curX ,int curY, int size,int[][] arr){
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (arr[curX + i][curY + j] != arr[curX][curY])
          return false;
      }
    }
    return true;
  }
}
