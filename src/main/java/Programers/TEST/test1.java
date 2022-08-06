
class Solution{

  //주어진 x , y  로 점들을 만들고, 가로로 평행하게 이은 변으로 만드는 사다리꼴 중 
  //면적 최대값 
  public int solution2(int[] x, int[] y){
    int answer = 0;

    Map<Integer,int[]> lineMap = new HashMap<>();

    //lineMap - y , {x최소 , x최대}
    for(int i=0;i<x.length;i++){
      if(lineMap.containsKey(y[i])){
        int[] line = lineMap.get(y[i]);
        line[0] = Math.min(line[0],x[i]);
        line[1] = Math.max(line[1],x[i]);
        lineMap.put(y[i],line);
      }else{
        lineMap.put(y[i],new int[]{x[i],x[i]});
      }
    }
    //변이 안된 점 제거
    for(int dy : y){
      if(lineMap.get(dy)[0]==lineMap.get(dy)[1]){
        lineMap.remove(dy);
      }
    }

    //순회하며 최대값 도출
    for(Integer y1 : lineMap.keySet()){
      int[] line1 = lineMap.get(y1);
      for(Integer y2 : lineMap.keySet()){
        int[] line2 = lineMap.get(y2);
        answer = Math.max(answer,((line1[1]-line1[0])+(line2[1]-line2[0]))*Math.abs(y2-y1));
      }
    }

    return answer;
  }

  //주어진 배터리 가격표 battery - {(갯수),(총 가격)....}
  //로 n 개의 배터리를 구입할 때 , 가장 저렴하게 구입한 금액 리턴.
  public int solution3(int n, int[][] battery){
    int answer = 0;

    PriorityQueue<PriceInfo> que = new PriorityQueue<PriceInfo>((o1, o2) -> o1.getPricePerOne() > o2.getPricePerOne() ? 1:-1);
    PriorityQueue<Integer> overPurchase = new PriorityQueue<>();

    for(int[] data:battery)
      que.add(new PriceInfo(data[0],data[1]));

    while(!que.isEmpty()){
      PriceInfo info = que.poll();
      int count = n/info.getCnt();
      n= n - count * info.getCnt();
      answer += count * info.getPrice();
      overPurchase.add(answer+info.getPrice());
      if(n == 0) break;
    }

    if(n > 0)
      return overPurchase.poll();

    return Math.min(answer,overPurchase.poll());
  }
}
class PriceInfo{
  int cnt;
  int price;
  int pricePerOne;

  public int getCnt(){
    return this.cnt;
  }
  public int getPrice(){
    return this.price;
  }
  public int getPricePerOne(){
    return this.pricePerOne;
  }
  public PriceInfo(int cnt,int price){
    this.cnt = cnt;
    this.price = price;
    this.pricePerOne = price/cnt;
  }
}




