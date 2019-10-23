import java.util.*;

class Solution19 {
  public static void main(String[] args) {
    String str1 = "aabbaccc";
    String str2 = "ababcdcdababcdcd";
    String str3 = "abcabcdede";
    String str4 = "abcabcabcabcdededededede";
    String str5 = "xababcdcdababcdcd";
    String str6 = "aaaaaaaaaaab";
    System.out.println(new Solution19().solution(str5));
  }

  public int zip(String s, int splitNum) {
    String result = "";
    String prev = "";
    int accum = 1;
    for (int i = 0; i < s.length(); i += splitNum) {
      if (i + splitNum > s.length()) {
        result += accum > 1 ? accum + s.substring(i) : s.substring(i);
        accum = 0;
        break;
      }

      String tmp = s.substring(i, i + splitNum);
      if (prev.equals(tmp)) {
        accum += 1;
      } else {
        result += accum > 1 ? accum + tmp : tmp;
        prev = tmp;
        accum = 1;
      }
    }
    result += accum > 1 ? accum : "";
    return result.length();
  }

  public int solution(String s) {
    int len = s.length();
    int answer = len;

    for (int i = 1; i <= len / 2; i++) {
      int tmp = zip(s, i);
      answer = tmp < answer ? tmp : answer;
    }

    return answer;
  }
}