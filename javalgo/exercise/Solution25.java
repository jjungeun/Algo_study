import java.util.ArrayList;

class Solution25 {
  public static void main(String[] args) {
    new Solution25().solution(10000000000L);
  }

  public int[] solution(long n) {
    ArrayList<Integer> answer = new ArrayList<>();
    while (n >= 1) {
      answer.add((int) (n % 10));
      n = (long) n / 10;
    }

    return answer.stream().mapToInt(i -> i).toArray();
  }
}