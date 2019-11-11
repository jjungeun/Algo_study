import java.util.*;

class Solution56 {
  public static void main(String[] args){
    System.out.println(new Solution56().solutionStack("()(((()())(())()))(())"));
  }

  // 스택사용하지 않은 풀이
  public int solution(String arrangement) {
    int answer = 0;
    int bar = 0;
    char pre = '\0';
    for(int i=0;i<arrangement.length();i++){
      char now = arrangement.charAt(i);
      if (pre=='(' && now == ')'){
        answer--;
        bar--;
        answer += bar;
      } else if (now == '('){
        answer++;
        bar++;
      } else if (now == ')'){
        bar--;
      }
      pre = now;
    }
    
    return answer;
  }

  //스택 사용한 풀이
  public int solutionStack(String arrangement){
    int answer = 0;
    Stack<Integer> stack = new Stack<>();
    char[] arr = arrangement.toCharArray();

    for(int i=0;i<arr.length;i++){
      if(arr[i] == '('){
        stack.push(i);
        answer ++;
      } else {
        answer = stack.pop() == i-1 ? answer + stack.size() - 1 : answer;
      }
    }

    return answer;
  }
}