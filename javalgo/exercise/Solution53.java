class Solution53 {
  public static void main(String[] args) {
    int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
        { 0, 0, 0, 3 } };
    int[] ans = new Solution53().solution(6, 4, picture);
    for (int a : ans) {
      System.out.println(a);
    }
  }

  int getArea(int a, int b, int color, int[][] picture, boolean[][] check) {
    int area = 1;
    check[a][b] = true;
    // 왼쪽
    if (b - 1 >= 0 && !check[a][b - 1] && picture[a][b - 1] == color) {
      area += getArea(a, b - 1, color, picture, check);
    }
    // 오른쪽
    if (picture[a].length > b + 1 && !check[a][b + 1] && picture[a][b + 1] == color) {
      area += getArea(a, b + 1, color, picture, check);
    }
    // 위
    if (a - 1 >= 0 && !check[a - 1][b] && picture[a - 1][b] == color) {
      area += getArea(a - 1, b, color, picture, check);
    }
    // 아래
    if (picture.length > a + 1 && !check[a + 1][b] && picture[a + 1][b] == color) {
      area += getArea(a + 1, b, color, picture, check);
    }
    return area;
  }

  public int[] solution(int m, int n, int[][] picture) {
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    int[] answer = new int[2];
    boolean[][] check = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (!check[i][j] && picture[i][j] != 0) {
          numberOfArea++;
          int color = picture[i][j];
          int tmp = getArea(i, j, color, picture, check);
          maxSizeOfOneArea = tmp > maxSizeOfOneArea ? tmp : maxSizeOfOneArea;
        }
      }
    }

    answer[0] = numberOfArea;
    answer[1] = maxSizeOfOneArea;
    return answer;
  }
}