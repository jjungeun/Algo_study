class Solution23 {
  public static void main(String[] args) {
    System.out.println(new Solution23().solution("Z z", 1));
  }

  public String solution(String s, int n) {
    String answer = "";
    char c, tmp;
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      if (c == ' ') {
        answer += " ";
        continue;
      } else if (c >= 'a') {
        tmp = (char) ('a' + (c + n - 'a') % ('z' - 'a' + 1));
      } else {
        tmp = (char) ('A' + (c + n - 'A') % ('Z' - 'A' + 1));
      }
      answer += Character.toString(tmp);
    }
    return answer;

    // ------------------------------------------------------
    // 좀 더 간결한 코드
    // 대소문자 판별시 isLowerCase/isUpperCase 함수 사용
    // String에 char붙일때 String으로 변환하지 않고 그냥 붙여도 됨
    // ------------------------------------------------------
    // String answer = "";
    // char c;
    // for (int i = 0; i < s.length(); i++) {
    // c = s.charAt(i);
    // if (Character.isLowerCase(c)) {
    // c = (char) ('a' + (c + n - 'a') % ('z' - 'a' + 1));
    // } else if (Character.isUpperCase(c)) {
    // c = (char) ('A' + (c + n - 'A') % ('Z' - 'A' + 1));
    // }
    // answer += c;
    // }
    // return answer;
  }
}