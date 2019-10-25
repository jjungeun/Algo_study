import java.util.Arrays;

class Solution26 {
  public static void main(String[] args) {
    System.out.println(new Solution26().solution(118372L));
  }

  public long solution(long n) {
    long answer = 0;
    Integer[] arr = new Integer[(int) Math.log10(n) + 1];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (n % 10);
      n /= 10;
    }

    Arrays.sort(arr);

    for (int i = 0; i < arr.length; i++) {
      answer += arr[i] * Math.pow(10, i);
    }
    return answer;
  }
}