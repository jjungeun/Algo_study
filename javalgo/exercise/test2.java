import java.util.*;

// ��� ���� ��������
class Solution {
  public String solution(String s) {
    int idx = s.length() / 2;
    if (s.length() % 2 == 0) {
      return Character.toString(s.charAt(idx - 1)) + Character.toString(s.charAt(idx));
    } else {
      return Character.toString(s.charAt(idx));
    }
    // �Ʒ��� best Ǯ�� : �ε����� substring ����ϱ�
    // return s.substring((s.length() - 1) / 2, s.length() / 2 + 1);
  }
}

public class test2 {
  public static void main(String[] args) {
    String s = "abcde";
    Solution sol = new Solution();
    System.out.println(sol.solution(s));
  }
}