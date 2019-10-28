class Solution34 {
  public static void main(String[] args) {
    System.out.println(new Solution34().solution("0103334444"));
  }

  public String solution(String phone_number) {
    String answer = phone_number.substring(0, phone_number.length() - 4).replaceAll("[0-9]", "*");
    return answer + phone_number.substring(phone_number.length() - 4);

    // -----------------------------------------
    // Other solution
    // String -> (toCharArray) -> Char array
    // String <- (String.valueOf) <- Char array
    // -----------------------------------------
    // char[] ch = phone_number.toCharArray();
    // for (int i = 0; i < ch.length - 4; i++) {
    // ch[i] = '*';
    // }
    // return String.valueOf(ch);
  }
}