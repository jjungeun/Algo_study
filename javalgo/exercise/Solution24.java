class Solution24 {
  public static void main(String[] args) {
    System.out.println(new Solution24().solution("try hello"));
  }

  public String solution(String s) {
    String answer = "";
    int idx = 0;
    for (int i = 0; i < s.length(); i++) {
      answer += idx % 2 == 0 ? Character.toUpperCase(s.charAt(i)) : Character.toLowerCase(s.charAt(i));
      idx = s.charAt(i) == ' ' ? 0 : idx + 1;
    }
    return answer;
  }
}