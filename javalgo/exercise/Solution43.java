import java.util.*;

class Solution43 {
  public static void main(String[] args) {
    int[] ans = new Solution43().solution(4, new int[] { 4, 4, 4, 4 });
    // int[] ans = new Solution43().solution(5, new int[] { 2, 1, 2, 6, 2, 4, 3, 3
    // });
    for (int a : ans) {
      System.out.println(a);
    }
  }

  public int[] solution(int N, int[] stages) {
    int[] answer = new int[N];
    HashMap<Integer, Double> fail = new HashMap<>();
    int idx = 0;
    int sum = stages.length;

    Arrays.sort(stages);

    for (int i = 1; i < N + 1; i++) {
      int tmp = idx;
      if (sum == 0) {
        fail.put(i, 0.0);
        continue;
      }
      for (int j = idx; j < stages.length; j++) {
        if (stages[j] > i)
          break;
        idx++;
      }
      fail.put(i, (double) (idx - tmp) / sum);
      sum -= (idx - tmp);
    }

    List<Map.Entry<Integer, Double>> list = new LinkedList<>(fail.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
      @Override
      public int compare(Map.Entry<Integer, Double> e1, Map.Entry<Integer, Double> e2) {
        return e2.getValue().compareTo(e1.getValue());
      }
    });

    Iterator<Map.Entry<Integer, Double>> iter = list.iterator();
    for (int i = 0; i < N; i++) {
      answer[i] = iter.next().getKey();
    }
    return answer;
  }
}