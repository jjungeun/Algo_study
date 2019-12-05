import java.util.*;

class Solution66 {
  public static void main(String[] args) {
    String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
        { "green_turban", "headgear" } };
    System.out.println(new Solution66().solution(clothes));
  }

  public int solution(String[][] clothes) {
    int answer = 1;
    HashMap<String, Integer> map = new HashMap<>();
    for (String[] c : clothes) {
      if (map.get(c[1]) == null) {
        map.put(c[1], 1);
      } else {
        map.put(c[1], map.get(c[1]) + 1);
      }
    }

    Iterator<String> iter = map.keySet().iterator();
    while (iter.hasNext()) {
      answer *= (map.get(iter.next()) + 1);
    }

    return answer - 1;
  }
}