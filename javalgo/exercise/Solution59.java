class Solution59 {
  public static void main(String[] args){
    System.out.println(new Solution59().solution("()))((()"));
  }

  boolean isBalance(String str){
    return str.charAt(0) == '(' && str.charAt(str.length()-1) == ')';
  }

  String reverse(String str){
    String ans = "";
    for(int i=0; i<str.length();i++){
      ans += str.charAt(i) == '(' ? ")" : "(";
    }
    return ans;
  }

  public String solution(String w) {
    String u = "";
    String v = "";
    int count = 0;
    if(w.equals("")){
      return "";
    }

    for(int i=0;i<w.length();i++){
      if(w.charAt(i)=='('){
        count++;
      } else {
        count--;
      }

      if(count == 0){
        u = w.substring(0, i+1);
        v = w.substring(i+1);
        break;
      }
    }

    if(isBalance(u)){
      return u + solution(v);
    } else {
      return "(" + solution(v) + ")" + reverse(u.substring(1, u.length()-1));
    }
  }
}