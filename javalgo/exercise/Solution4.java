package exercise;

import java.util.*;

// 모의고사
public class Solution4 {
  public static void main(String[] args) {
    int[] ans = { 1, 3, 2, 4, 2 };
    Solution4 sol = new Solution4();
    System.out.println(Arrays.toString(sol.solution(ans)));
  }

  public int[] solution(int[] answers) {
    int[] one = { 1, 2, 3, 4, 5 };
    int[] two = { 2, 1, 2, 3, 2, 4, 2, 5 };
    int[] three = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

    List<Integer> score = new ArrayList<Integer>();
    for (int i = 0; i < 3; i++) {
      score.add(0);
    }

    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == one[i % one.length]) {
        score.set(0, score.get(0) + 1);
      }
      if (answers[i] == two[i % two.length]) {
        score.set(1, score.get(1) + 1);
      }
      if (answers[i] == three[i % three.length]) {
        score.set(2, score.get(2) + 1);
      }
    }

    int max = Collections.max(score);

    List<Integer> answerList = new ArrayList<Integer>();
    for (int i = 0; i < 3; i++) {
      if (score.get(i) == max) {
        answerList.add(i + 1);
      }
    }

    return answerList.stream().mapToInt(i -> i).toArray();
  }
}
