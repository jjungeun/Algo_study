import java.util.*;

class Solution51 {
  public static void main(String[] args){
    int[] ans = new Solution51().solution(new int[] {93,30,55}, new int[] {1,30,5});
    for(int a: ans){
      System.out.println(a);
    }
  }

  int popQ(Queue<Integer> progressQ, Queue<Integer> speedQ, int progress){
    if(!progressQ.isEmpty() && progressQ.element()+progress*speedQ.element() >= 100){
      progressQ.remove();
      speedQ.remove();
      return popQ(progressQ, speedQ, progress) + 1;
    }
    return 1;
  }

  public int[] solution(int[] progresses, int[] speeds) {
    ArrayList<Integer> numArr = new ArrayList<>();
    Queue<Integer> progressQ = new LinkedList<>();
    Queue<Integer> speedQ = new LinkedList<>();
    int progress = 0;
    for(int p: progresses){
      progressQ.add(p);
    }
    for(int s: speeds){
      speedQ.add(s);
    }

    while(!progressQ.isEmpty()){
      progress++;
      if(progressQ.element() + progress*speedQ.element() >= 100){
        progressQ.remove();
        speedQ.remove();
        numArr.add(popQ(progressQ,speedQ,progress));
      }
    }

    int[] answer = new int[numArr.size()];
    for(int i=0;i<answer.length;i++){
      answer[i] = numArr.get(i);
    }
    return answer;
  }
}