import java.util.Arrays;

class Solution32 {
  public static void main(String[] args) {
    System.out.println(new Solution32().solution(new int[] { 1, 2, 3, 4 }));
  }

  public double solution(int[] arr) {
    return (double) Arrays.stream(arr).sum() / arr.length;
  }
}