import java.util.*;

class Solution15 {
  public static void main(String[] args) {
    String s = "Zbcdefa";
    Solution15 sol = new Solution15();
    System.out.println(sol.solution(s));
  }

  public String solution(String s) {
    String answer = "";
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      list.add((int) s.charAt(i));
    }
    Collections.sort(list);

    for (int i = list.size() - 1; i >= 0; i--) {
      answer += Character.toString((char) (int) list.get(i));
    }

    return answer;

    // -----------------------------------------------------
    // best solution
    // ������ �빮�ڰ� ascii���� �۱⶧���� ��ȯ���� �ʿ䰡 ������.
    // Collections���� Arrays�� sort�Լ��� ����ϴ°��� ������.
    // ���ڿ��� ������ �� StringBuilder�� ����غ���
    // -----------------------------------------------------
    // char[] arr = s.toCharArray();
    // Arrays.sort(arr);
    // return new StringBuilder(new String(arr)).reverse().toString();

    // -----------------------------------------------------
    // best solution2
    // Collections�� reverseOrder�� �������.
    // ���� Ǯ�̿� ���� Arrays�� sort�� �����.
    // string array���� string���� ��ȯ�ϱ� ���� stringbuffer���
    // -----------------------------------------------------
    // String[] arr = s.split("");
    // Arrays.sort(arr, Collections.reverseOrder());
    // StringBuffer sb = new StringBuffer();
    // for (String str : arr) {
    // sb.append(str);
    // }
    // return sb.toString();
  }
}