class Solution76 {
	public static void main(String[] args) {
		String s = ")()(";
		System.out.println(new Solution76().solution(s));
	}

	boolean solution(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				count++;
			else if (s.charAt(i) == ')')
				count--;
			if (count < 0)
				return false;
		}
		return count == 0 ? true : false;
	}
}
