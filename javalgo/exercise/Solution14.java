class Solution14 {
  public static void main(String[] args) {
    String s = "qqpYooe";
    Solution14 sol = new Solution14();
    System.out.println(sol.solution(s));
  }

  boolean solution(String s) {
    int answer = 0;
    for (int i = 0; i < s.length(); i++) {
      switch ((int) s.charAt(i)) {
      case 80:
      case 112:
        answer++;
        break;
      case 89:
      case 121:
        answer--;
        break;
      default:
        break;
      }
    }

    return answer == 0;
  }
}