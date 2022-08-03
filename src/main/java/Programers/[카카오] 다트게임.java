
class Solution {
  public int solution(String dartResult) {
    int answer = 0;
    Stack<Integer> stack = new Stack<>();

    boolean isTen = false;
    for(String s:dartResult.split("")){
      if(s.matches("[0-9]")){
        //숫자 10 처리
        //for문을 index 기준으로 돌리는게 더 가독성은 좋아보임.
        if(isTen && "0".equals(s)){
          stack.pop();
          stack.push(10);
        }else{
          stack.push(Integer.parseInt(s));
        }
        if("1".equals(s)){
          isTen = true;
        }else{
          isTen = false;
        }
        continue;
      }else{
        option(stack,s);
        isTen = false;
      }
    }
    return stack.stream().mapToInt(Integer::intValue).sum();
  }

  void option(Stack<Integer> stack,String option){
    if(stack.isEmpty())return;
    int num1 = 0;
    int num2 = 0;
    switch (option){
      case "D":
        num1 = stack.pop();
        stack.push((int) Math.pow(num1,2));
        break;
      case "T":
        num1 = stack.pop();
        stack.push((int) Math.pow(num1,3));
        break;
      case "*":
        num1 = stack.pop()*2;
        if(!stack.isEmpty()){
          num2 = stack.pop()*2;
          stack.push(num2);
        }
        stack.push(num1);
        break;
      case "#":
        num1 = stack.pop()*(-1);
        stack.push(num1);
        break;
      default:
        break;
    }
  }


}
