class Solution33 {
  public static void main(String[] args) {
    System.out.println(new Solution33().solution(12));
  }

  public boolean solution(int x) {
    int answer = 0;
    int tmp = x;
    while (tmp >= 1) {
      answer += tmp % 10;
      tmp /= 10;
    }

    return x % answer == 0 ? true : false;

    // -------------------------
    // other solution
    // ���� �ڸ����� �迭�� �ٲٴ� ���
    // -------------------------
    // String[] tmp = String.valueOf(x).split("");
    // int answer = 0;
    // for (String s : tmp) {
    // answer += Integer.parseInt(s);
    // }

    // return x % answer == 0 ? true : false;
  }
}