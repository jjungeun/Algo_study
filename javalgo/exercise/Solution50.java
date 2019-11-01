import java.util.*;

class Solution50 {
  public static void main(String[] args) {
    // int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
    int[][] computers = { { 1, 1, 1, 0 }, { 1, 1, 1, 0 }, { 1, 1, 1, 0 }, { 0, 0, 0, 1 } };
    System.out.println(new Solution50().solution(4, computers));
  }

  static boolean[][] link;

  public void dfs(int[][] computers, int idx, int n) {
    for (int i = 0; i < n; i++) {
      if (computers[idx][i] == 1 && !link[idx][i]) {
        link[idx][i] = link[i][idx] = true;
        dfs(computers, i, n);
      }
    }
  }

  public int solution(int n, int[][] computers) {
    int answer = 0;
    link = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      if (!link[i][i]) {
        dfs(computers, i, n);
        answer++;
      }
    }
    return answer;
  }
}