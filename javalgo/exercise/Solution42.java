import java.util.Arrays;

class Solution42 {
  public static void main(String[] args) {
    System.out.println(new Solution42().solution(new int[] { 2, 2, 3, 3 }, 10));
  }

  public int solution(int[] d, int budget) {
    int answer = 0;
    Arrays.sort(d);
    for (int i = 0; i < d.length; i++) {
      budget -= d[i];
      if (budget < 0) {
        break;
      }
      answer++;
    }
    return answer;
  }
}