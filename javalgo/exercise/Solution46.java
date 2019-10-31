import java.util.*;

class Solution46 {
  public static void main(String[] args) {
    System.out.println(new Solution46().solution(2, 10, new int[] { 7, 4, 5, 6 }));
  }

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    Queue<Integer> queue = new LinkedList<>();
    int idx = 0;
    int sum = 0;

    for (int i = 0; i < bridge_length; i++) {
      queue.add(0);
    }

    while (queue.size() > 0) {
      sum -= (int) queue.remove();
      answer++;
      if (idx < truck_weights.length) {
        if (sum + truck_weights[idx] <= weight) {
          sum += truck_weights[idx];
          queue.add(truck_weights[idx]);
          idx++;
        } else {
          queue.add(0);
        }
      }
    }
    return answer;
  }
}