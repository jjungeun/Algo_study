import java.util.*;

class Solution41 {

  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int loop = sc.nextInt();
    int[] ans = new int[loop];
    for (int i = 0; i < loop; i++) {
      int p = sc.nextInt();
      int[][] point = new int[p][2];
      for (int j = 0; j < p; j++) {
        point[j][0] = sc.nextInt();
        point[j][1] = sc.nextInt();
      }
      ans[i] = getArea(4, point);
    }

    for (int a : ans) {
      System.out.println(a);
    }
  }

  static int getArea(int n, int[][] point) {
    int answer = 0;
    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    for (int[] p : point) {
      for (int i = p[0]; i < p[0] + 10; i++) {
        map.putIfAbsent(i, new HashSet<Integer>());
        for (int j = p[1]; j < p[1] + 10; j++) {
          map.get(i).add(j);
        }
      }
    }

    Iterator<Integer> iter = map.keySet().iterator();
    while (iter.hasNext()) {
      answer += map.get((int) iter.next()).size();
    }
    return answer;
  }
}