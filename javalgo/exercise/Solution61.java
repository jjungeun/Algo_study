import java.util.*;

class Solution61 {
  public static void main(String[] args) {
    System.out.println(new Solution61().solution(new int[] { 1, 2, 9, 3, 10, 12 }, 7));
  }

  boolean isSatisfy(Queue<Integer> heap, int K) {
    return heap.peek() > K ? true : false;
  }

  public int solution(int[] scoville, int K) {
    int answer = 0;
    Queue<Integer> heap = new PriorityQueue<>();
    for (int s : scoville) {
      heap.add(s);
    }

    while (!isSatisfy(heap, K)) {
      if (heap.size() < 2) {
        answer = -1;
        break;
      }

      int a = heap.poll();
      int b = heap.poll();
      heap.add(a + b * 2);
      answer++;
    }

    return answer;
  }
}