import java.util.Stack;

class Solution58 {
  public static void main(String[] args) {
    System.out.println(new Solution58().solution("1010", 2));
  }

  public String solution(String number, int k) {
    char[] answer = new char[number.length() - k];
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < number.length(); i++) {
      char c = number.charAt(i);
      while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
        stack.pop();
      }
      stack.push(c);
    }

    for (int i = 0; i < answer.length; i++) {
      answer[i] = stack.get(i);
    }
    return new String(answer);
  }
}