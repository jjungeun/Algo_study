import java.util.Stack;

public class Solution83 {
	public static void main(String[] args){
		String s = "abcceeab";
		System.out.println(new Solution83().solution(s));
	}
	public int solution(String s)
    {
		if (s.length() % 2 != 0)
			return 0;
		Stack<Character> stack = new Stack<>();
		for (int i=0; i<s.length();i++)
		{
			if (!stack.empty() && s.charAt(i) == stack.peek())
				stack.pop();
			else
				stack.push(s.charAt(i));
		}
		return stack.isEmpty() ? 1 : 0;
	}
}
