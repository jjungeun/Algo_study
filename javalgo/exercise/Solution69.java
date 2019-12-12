import java.util.Collections;
import java.util.PriorityQueue;

class Solution69 {
  public static void main(String[] args) {
    int[] dates = { 4, 10, 15 };
    int[] supplies = { 20, 5, 10 };
    System.out.println(new Solution69().solution(4, dates, supplies, 30));
  }

  public int solution(int stock, int[] dates, int[] supplies, int k) {
    int answer = 0;
    int day = stock;
    int idx = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    while (day < k) {
      while (idx < dates.length && dates[idx] <= day) {
        System.out.println(dates[idx]);
        System.out.println(day);
        queue.add(supplies[idx]);
        idx++;
      }
      System.out.println();
      day += queue.poll();
      answer++;
    }
    return answer;
  }
}