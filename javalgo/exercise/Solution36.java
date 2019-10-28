class Solution36 {
  public static void main(String[] args) {
    System.out.println(new Solution36().solution("1D20S*3T#"));
  }

  public int solution(String dartResult) {
    int answer = 0;
    String[] arr = dartResult.split("[A-Z]");
    char[] ch = dartResult.toCharArray();
    int[] ans = new int[3];
    int idx = 0;
    int ansIdx = 0;

    for (String s : arr) {
      if (s.matches("^[0-9]+")) {
        ans[ansIdx] = Integer.valueOf(s);
        idx += s.length();
      } else {
        if (s.startsWith("*")) {
          ans[ansIdx - 1] *= 2;
          if (ansIdx - 2 >= 0) {
            ans[ansIdx - 2] *= 2;
          }
        } else if (s.startsWith("#")) {
          ans[ansIdx - 1] *= -1;
        }

        if (s.length() > 1) {
          ans[ansIdx] = Integer.valueOf(s.substring(1));
        }

        idx += s.length();
      }

      if (ansIdx == 3)
        break;

      if (ch[idx] == 'D') {
        ans[ansIdx] = (int) Math.pow(ans[ansIdx], 2);
      } else if (ch[idx] == 'T') {
        ans[ansIdx] = (int) Math.pow(ans[ansIdx], 3);
      }

      idx++;
      ansIdx++;
    }

    for (int i = 0; i < ans.length; i++)
      answer += ans[i];

    return answer;
  }
}