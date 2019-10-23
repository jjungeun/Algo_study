class Solution20 {
  public static void main(String[] args) {
    System.out.println(new Solution20().solution("+12345"));
  }

  public int solution(String s) {
    // 간단한 풀이
    return Integer.parseInt(s);

    // 알고리즘 풀이
    // int answer = 0;
    // char sign = '+';
    // if (s.charAt(0) < '0') {
    // sign = s.charAt(0);
    // s = s.substring(1);
    // }

    // for (int i = 0; i < s.length(); i++) {
    // answer = answer * 10 + s.charAt(i) - '0';
    // }

    // return sign == '+' ? answer : answer * -1;
  }
}