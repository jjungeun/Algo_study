import java.util.Arrays;

class Solution16 {
  public static void main(String[] args) {
    String[] seoul = { "Jane", "Kim" };
    Solution16 sol = new Solution16();
    System.out.println(sol.solution(seoul));
  }

  public String solution(String[] seoul) {
    int answer = 0;
    for (int i = 0; i < seoul.length; i++) {
      if (seoul[i].equals("Kim")) {
        answer = i;
        break;
      }
    }
    return "김서방은 " + Integer.toString(answer) + "에 있다";

    // ----------------------------------------------------
    // best solution
    // Arrays.asList()는 배열을 list처럼 사용하는 방법이다. 
    // 원소 추가나 삭제는 못하지만 이 문제처럼 탐색하는 경우 유용하다.
    // ----------------------------------------------------
    // int answer = Arrays.asList(seoul).indexOf("Kim");
    // return "김서방은 " + answer + "에 있다";
  }
}