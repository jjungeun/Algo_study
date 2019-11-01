import java.util.*;

class Solution47 {
  public static void main(String[] args) {
    System.out.println(new Solution47().solution(new int[] { 0, 0, 0, 0 }));
  }

  boolean find_max(String a, String b) {
    return a.length() == b.length() ? Integer.valueOf(a) <= Integer.valueOf(b)
        : Integer.valueOf(a + b) <= Integer.valueOf(b + a);
  }

  ArrayList<String> quick_sort(ArrayList<String> num) {
    int len = num.size();
    if (len <= 1) {
      return num;
    } else {
      String now = num.get(0);
      ArrayList<String> greater = new ArrayList<>();
      ArrayList<String> less = new ArrayList<>();
      for (int i = 1; i < len; i++) {
        if (find_max(now, num.get(i))) {
          greater.add(num.get(i));
        } else {
          less.add(num.get(i));
        }
      }
      ArrayList<String> ans = quick_sort(greater);
      ans.add(now);
      ans.addAll(quick_sort(less));
      return ans;
    }
  }

  public String solution(int[] numbers) {
    String answer = "";
    ArrayList<String> num = new ArrayList<String>();
    for (int i = 0; i < numbers.length; i++) {
      num.add(Integer.toString(numbers[i]));
    }
    num = quick_sort(num);

    for (int i = 0; i < num.size(); i++) {
      answer += num.get(i);
      if (num.get(0).equals("0"))
        break;
    }
    return answer;
  }
}