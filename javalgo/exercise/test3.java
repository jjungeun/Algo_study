package javalgo.exercise;

class Solution {
  public boolean isMixed(String s) {
    for (int i =0; i<s.length(); i++) {
      int idx = s.charAt(i);
      if (idx >= 65 && idx <= 122){
        return true;
      }
    }
    return false;
  }

  public boolean solution(String s) {
      if ((s.length() == 4 || s.length() == 6) && !isMixed(s)){
        return true;
      }
      return false;
  }
}

public class test3 {
  public static void main(String[] args) {
    String s = "1234";
    Solution sol = new Solution();
    System.out.println(sol.solution(s));
  }
}