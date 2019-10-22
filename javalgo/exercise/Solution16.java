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
    return "�輭���� " + Integer.toString(answer) + "�� �ִ�";

    // ----------------------------------------------------
    // best solution
    // Arrays.asList()�� �迭�� listó�� ����ϴ� ����̴�. 
    // ���� �߰��� ������ �������� �� ����ó�� Ž���ϴ� ��� �����ϴ�.
    // ----------------------------------------------------
    // int answer = Arrays.asList(seoul).indexOf("Kim");
    // return "�輭���� " + answer + "�� �ִ�";
  }
}