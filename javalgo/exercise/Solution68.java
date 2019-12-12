class Solution68 {
  public static void main(String[] args) {
    int[] ans = new Solution68().solution(10, 2);
    for (int a : ans)
      System.out.println(a);
  }

  public int[] solution(int brown, int red) {
    for (int horizon = 3; horizon < brown / 2; horizon++) {
      for (int vertical = 3; vertical <= horizon; vertical++) {
        if (brown + red == horizon * vertical && horizon * 2 + vertical * 2 - 4 == brown) {
          return new int[] { horizon, vertical };
        }
      }
    }
    return new int[] {};
  }
}