class Solution45 {
  public static void main(String[] args) {
    System.out.println(new Solution45().solution(13));
  }

  public String solution(int n) {
    StringBuffer answer = new StringBuffer();
    String[] num = { "1", "2", "4" };

    while (n >= 1) {
      answer.append(num[(n - 1) % 3]);
      n = (n - 1) / 3;
    }
    return answer.reverse().toString();
  }
}