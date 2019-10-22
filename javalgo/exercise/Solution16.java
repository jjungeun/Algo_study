class Solution16 {
  public static void main(String[] args) {
    String[] seoul = { "Jane", "Kim" };
    Solution16 sol = new Solution16();
    System.out.println(sol.solution(seoul));
  }

  public String solution(String[] seoul) {
    int answer = 0;
    for (int i = 0; i < seoul.length; i++) {
      if (seoul[i] == "Kim") {
        answer = i;
      }
    }
    return "김서방은 " + Integer.toString(answer) + "에 있다";
  }
}