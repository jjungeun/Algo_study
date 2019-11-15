import java.util.Arrays;

class Solution63 {
  public static void main(String[] args) {
    System.out.println(new Solution63().solution(new int[] { 22, 42 }));
  }

  public int solution(int[] citations) {
    Arrays.sort(citations);

    for (int i = citations.length; i > 0; i--) {
      if (citations[citations.length - i] >= i) {
        return i;
      }
    }
    return 0;
  }
}