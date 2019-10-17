// 2016³â
class Solution8 {
  public static void main(String[] args) {
    Solution8 sol = new Solution8();
    System.out.println(sol.solution(5, 24));
  }

  public String solution(int a, int b) {
    String[] month = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
    int[] day = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    int all = b + 4;
    for (int i = 0; i < a - 1; i++) {
      all += day[i];
    }

    return month[all % 7];
  }
}