public class Solution12 {
  public static void main(String[] args) {
    Solution12 sol = new Solution12();
    System.out.println(sol.solution(3, 5));
  }

  public long solution(int a, int b) {
    long answer = 0;
    int small = Math.min(a, b);
    int big = Math.max(a, b);
    // 내가 푼 방법
    for (int i = small; i <= big; i++) {
      answer += (long) i;
    }
    // 베스트 방법(중간값을 계산)))
    // answer = (big - small + 1) * (big + small) / 2;
    return answer;
  }
}