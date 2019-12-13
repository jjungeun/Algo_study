class Solution70 {
  public static void main(String[] args) {
    int[][] board = { { 1, 1, 1, 1 }, { 0, 1, 1, 1 }, { 0, 1, 1, 1 } };
    System.out.println(new Solution70().solution(board));
  }

  public int solution(int[][] board) {
    int answer = 0;
    int[][] arr = new int[board.length + 1][board[0].length + 1];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        arr[i + 1][j + 1] = board[i][j] == 1 ? 1 : 0;
      }
    }

    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j < arr[i].length; j++) {
        if (arr[i][j] == 1) {
          int min = Math.min(arr[i - 1][j], arr[i][j - 1]);
          min = Math.min(min, arr[i - 1][j - 1]);

          arr[i][j] = min + 1;
          answer = Math.max(answer, arr[i][j]);
        }
      }
    }
    return answer * answer;
  }
}