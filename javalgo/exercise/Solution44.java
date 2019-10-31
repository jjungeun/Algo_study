class Solution44 {
  public static void main(String[] args) {
    int[] ans = new Solution44().solution(new int[] { 10, 9, 5, 7, 4 });
    for (int a : ans)
      System.out.println(a);
  }

  private int getTop(int idx, int[] top) {
    int ans = 0;
    int now = top[idx];
    while (idx > 0) {
      if (top[--idx] > now)
        return idx + 1;
    }
    return ans;
  }

  public int[] solution(int[] heights) {
    int[] answer = new int[heights.length];
    for (int idx = 0; idx < heights.length; idx++) {
      answer[idx] = getTop(idx, heights);
    }
    return answer;
  }

}