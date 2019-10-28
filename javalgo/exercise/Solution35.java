class Solution35 {
  public static void main(String[] args) {
    int[][] arr1 = { { 1, 2 }, { 2, 3 } };
    int[][] arr2 = { { 3, 4 }, { 5, 6 } };
    int[][] ans = new Solution35().solution(arr1, arr2);
    for (int[] i : ans)
      for (int j : i)
        System.out.println(j);
  }

  public int[][] solution(int[][] arr1, int[][] arr2) {
    int[][] answer = new int[arr1.length][arr1[0].length];
    for (int i = 0; i < answer.length; i++) {
      for (int j = 0; j < answer[i].length; j++) {
        answer[i][j] = arr1[i][j] + arr2[i][j];
      }
    }
    return answer;
  }
}