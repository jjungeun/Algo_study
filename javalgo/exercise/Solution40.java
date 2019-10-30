import java.util.*;
import java.io.*;

class Solution40 {
  public static Scanner scanner = new Scanner(System.in);

  public static String getFig(int x, int y) {
    if (x == 0 && y == 0)
      return "DOT";
    else if (x == 0 || y == 0)
      return "SEGMENT";
    else if (x == y)
      return "SQUARE";
    else
      return "RECTANGLE";
  }

  public static void main(String[] args) { // 프로그램의 시작부
    // 첫 번째 점 P의 좌표
    int px = scanner.nextInt();
    int py = scanner.nextInt();
    // 두 번째 점 Q의 좌표
    int qx = scanner.nextInt();
    int qy = scanner.nextInt();

    int x = Math.abs(px - qx);
    int y = Math.abs(py - qy);

    System.out.println(getFig(x, y));
  }
}