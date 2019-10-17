// 자릿수 더하기
class Solution7 {
  public static void main(String[] args) {
    int n = 123;
    Solution7 sol = new Solution7();
    System.out.println(sol.solution(n));
  }

  public int solution(int n) {
    int answer = 0;

    // ---------------------------------------
    // my solution
    // ---------------------------------------
    String str = Integer.toString(n);
    for (int i = 0; i < str.length(); i++) {
      answer += Integer.parseInt(String.valueOf(str.charAt(i)));
    }

    // ---------------------------------------
    // solution not using type conversion
    // ---------------------------------------
    // while (true) {
    // answer += n % 10;
    // if (n < 10)
    // break;
    // n = n / 10;
    // }

    return answer;
  }
}