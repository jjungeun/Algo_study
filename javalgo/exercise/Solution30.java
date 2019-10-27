import java.util.*;

class Solution30 {
  public static void main(String[] args) {
    int[] ans = new Solution30().solution(2, 5);
    for (int i = 0; i < ans.length; i++)
      System.out.println(ans[i]);
  }

  int gcd(int a, int b) {
    if (b == 0)
      return a;
    return gcd(b, a % b);
  }

  public int[] solution(int n, int m) {
    int[] answer = new int[2];
    int min = Integer.min(n, m);
    int max = Integer.max(n, m);
    int gcd = 1;
    ArrayList<Integer> arr = new ArrayList<>();

    arr.add(min);
    for (int i = min / 2; i > 1; i--) {
      if (min % i == 0) {
        arr.add(i);
      }
    }

    for (int i = 0; i < arr.size(); i++) {
      if (max % arr.get(i) == 0) {
        gcd = arr.get(i);
        break;
      }
    }

    answer[0] = gcd;
    answer[1] = min * max / gcd;

    return answer;

    // ------------------------
    // best solution
    // 재귀함수 사용
    // ------------------------
    // int[] answer = new int[2];
    // answer[0] = gcd(m, n);
    // answer[1] = (m * n) / answer[0];
    // return answer;
  }
}