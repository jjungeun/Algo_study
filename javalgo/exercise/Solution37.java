class Solution37 {
  public static void main(String[] args) {
    long[] ans = new Solution37().solution(-4, 2);
    for (int i = 0; i < ans.length; i++)
      System.out.println(ans[i]);
  }

  public long[] solution(int x, int n) {
    long[] answer = new long[n];
    for (int i = 0; i < n; i++) {
      answer[i] = (long) x * (i + 1);
    }
    return answer;
  }
}