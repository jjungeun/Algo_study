class Solution54 {
  public static void main(String[] args) {
    System.out.println(new Solution54().solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA" }));
  }

  boolean isSort(String tmp, String skill) {
    int idx = 0;
    char[] tmpArr = tmp.toCharArray();
    char[] skillArr = skill.toCharArray();
    for (char t : tmpArr) {
      if (t != skillArr[idx]) {
        return false;
      }
      idx++;
    }
    return true;
  }

  public int solution(String skill, String[] skill_trees) {
    int answer = 0;

    for (String sk : skill_trees) {
      String tmp = "";
      for (int i = 0; i < sk.length(); i++) {
        String s = sk.substring(i, i + 1);
        tmp += skill.contains(s) ? s : "";
      }
      answer += isSort(tmp, skill) ? 1 : 0;
    }
    return answer;
  }
}