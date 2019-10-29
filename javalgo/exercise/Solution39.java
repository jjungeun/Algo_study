class Solution39 {
  public static void main(String[] args) {
    String[] ans = new Solution39().solution(5, new int[] { 9, 20, 28, 18, 11 }, new int[] { 30, 1, 21, 17, 28 });
    for (String s : ans)
      System.out.println(s);
  }

  String map(int n, String s1, String s2) {
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    String s = "";
    for (int i = 0; i < n; i++) {
      System.out.println(c1[i] + " " + c2[i]);
      s += (char) (c1[i] | c2[i]) == '1' ? "#" : " ";
    }
    return s;
  }

  public String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];

    for (int i = 0; i < n; i++) {
      String tmp1 = String.format("%" + n + "s", Integer.toBinaryString(arr1[i]));
      String tmp2 = String.format("%" + n + "s", Integer.toBinaryString(arr2[i]));
      answer[i] = map(n, tmp1, tmp2);
    }

    return answer;

    // ------------------------------------------
    // other solution
    // 한번에 or연산을 하고 2진수로 바꾸면 간단한 문제
    // format함수와 replaceAll 함수사용을 익히자
    // ------------------------------------------
    // String[] answer = new String[n];
    // for (int i = 0; i < n; i++) {
    // String tmp = Integer.toBinaryString(arr1[i] | arr2[i]);
    // answer[i] = String.format("%" + n + "s", tmp).replaceAll("1",
    // "#").replaceAll("0", " ");
    // }

    // return answer;
  }
}