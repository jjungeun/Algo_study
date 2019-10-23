class Solution18 {
  public static void main(String[] args) {
    System.out.println(new Solution18().solution(4));
  }

  public String solution(int n) {
    String[] answer = new String[n];
    for (int i = 0; i < n; i++) {
      answer[i] = Character.toString("����".charAt(i % 2));
    }
    return String.join("", answer);

    // -----------------------------------
    // best solution
    // ���׿����ڸ� Ȱ������.
    // -----------------------------------
    // String answer = "";
    // for (int i = 0; i < n; i++) {
    // answer += i % 2 == 0 ? "��" : "��";
    // }
    // return answer;
  }
}