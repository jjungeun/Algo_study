class Solution29 {
  public static void main(String[] args) {
    System.out.println(new Solution29().solution(4));
  }

  public String solution(int num) {
    return num % 2 == 0 ? "Even" : "Odd";
  }
}