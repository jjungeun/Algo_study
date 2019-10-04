package javalgo.exercise;

import java.util.HashMap;

class Solution {
  public String solution(String[] participant, String[] completion) {
    String answer = "";
    HashMap<String, Integer> map = new HashMap<>();

    for (String p : participant) {
      map.put(p, map.getOrDefault(p, 0) + 1);
    }
    for (String c : completion) {
      map.put(c, map.get(c) - 1);
    }

    for (String key : map.keySet()) {
      if (map.get(key) != 0) {
        answer = key;
        break;
      }
    }
    return answer;
  }
}

public class test1 {
  public static void main(String[] args) {
    String[] participant = { "leo", "kiki", "eden" };
    String[] completion = { "eden", "kiki" };
    Solution sol = new Solution();
    System.out.println(sol.solution(participant, completion));
  }
}
