public class Hanoi {
  static void hanoi(int n, int x, int y) {
    if (n > 1)
      hanoi(n - 1, x, 6 - x - y);

    System.out.println("원반[" + n + "]을 " + x + "에서 " + y + "로 옮김");

    if (n > 1)
      hanoi(n - 1, 6 - x - y, y);
  }

  public static void main(String[] args) {
    hanoi(3, 1, 3);
  }
}