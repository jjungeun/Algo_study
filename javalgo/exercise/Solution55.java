import java.util.*;

class Solution55 {
  public static void main(String[] args) {
    System.out.println(new Solution55().solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0));
  }

  boolean isMax(Queue<Integer> queue, int num) {
    Iterator<Integer> iter = queue.iterator();
    while (iter.hasNext()) {
      if ((int) iter.next() > num)
        return false;
    }
    return true;
  }

  public int solution(int[] priorities, int location) {
    int answer = 0;
    Queue<Integer> queue = new LinkedList<>();
    for (int p : priorities) {
      queue.add(p);
    }

    while (!queue.isEmpty()) {
      int num = queue.poll();
      if (isMax(queue, num)) {
        answer++;
        if (location == 0)
          break;
      } else {
        queue.add(num);
      }
      location = (location + queue.size() - 1) % queue.size();
    }
    return answer;
  }
}