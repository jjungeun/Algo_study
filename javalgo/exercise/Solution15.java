import java.util.*;

class Solution15 {
  public static void main(String[] args) {
    String s = "Zbcdefa";
    Solution15 sol = new Solution15();
    System.out.println(sol.solution(s));
  }

  public String solution(String s) {
    String answer = "";
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      list.add((int) s.charAt(i));
    }
    Collections.sort(list);

    for (int i = list.size() - 1; i >= 0; i--) {
      answer += Character.toString((char) (int) list.get(i));
    }

    return answer;

    // -----------------------------------------------------
    // best solution
    // 어차피 대문자가 ascii값이 작기때문에 변환해줄 필요가 없었음.
    // Collections말고 Arrays의 sort함수를 사용하는것이 좋았음.
    // 문자열을 뒤집을 때 StringBuilder를 사용해보기
    // -----------------------------------------------------
    // char[] arr = s.toCharArray();
    // Arrays.sort(arr);
    // return new StringBuilder(new String(arr)).reverse().toString();

    // -----------------------------------------------------
    // best solution2
    // Collections의 reverseOrder를 사용했음.
    // 위의 풀이와 같이 Arrays의 sort로 사용함.
    // string array에서 string으로 변환하기 위해 stringbuffer사용
    // -----------------------------------------------------
    // String[] arr = s.split("");
    // Arrays.sort(arr, Collections.reverseOrder());
    // StringBuffer sb = new StringBuffer();
    // for (String str : arr) {
    // sb.append(str);
    // }
    // return sb.toString();
  }
}