import java.util.ArrayList;
import java.util.Iterator;

class Solution64 {
  public static void main(String[] args) {
    int[][] baseball = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };
    System.out.println(new Solution64().solution(baseball));
  }

  boolean isAnswer(String object, int[] b) {
    String ans = Integer.toString(b[0]);
    int strike = 0;
    int ball = 0;
    char[] arr = ans.toCharArray();
    for (int i = 0; i < 3; i++) {
      if (object.indexOf(arr[i]) >= 0) {
        if (object.charAt(i) == arr[i]) {
          strike++;
        } else {
          ball++;
        }
      }
    }
    return b[1] == strike && b[2] == ball;
  }

  public int solution(int[][] baseball) {
    ArrayList<String> list = new ArrayList<>();
    for (int i = 1; i < 10; i++) {
      for (int j = 1; j < 10; j++) {
        for (int k = 1; k < 10; k++) {
          if (i != j && j != k && i != k) {
            list.add(Integer.toString(i) + Integer.toString(j) + Integer.toString(k));
          }
        }
      }
    }

    for (int[] b : baseball) {
      ArrayList<String> notAns = new ArrayList<>();
      Iterator<String> iter = list.iterator();
      while (iter.hasNext()) {
        String object = iter.next();
        if (!isAnswer(object, b)) {
          notAns.add(object);
        }
      }
      list.removeAll(notAns);
    }

    return list.size();
  }
}