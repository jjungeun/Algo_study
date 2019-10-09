package javalgo.exercise;

// 문자열 다루기 기본
class Solution3 {
  public static void main(String[] args) {
    String s = "1234";
    Solution3 sol = new Solution3();
    System.out.println(sol.solution(s));
  }

  public boolean isMixed(String s) {
    for (int i = 0; i < s.length(); i++) {
      int idx = s.charAt(i);
      if (idx >= 65 && idx <= 122) {
        return true;
      }
    }
    return false;
  }

  public boolean solution(String s) {
    if ((s.length() == 4 || s.length() == 6) && !isMixed(s)) {
      return true;
    }
    return false;
  }
}