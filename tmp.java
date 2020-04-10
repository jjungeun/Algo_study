class tmp {
	public static void main(String[] argv) {
		String s = "cde";
		System.out.println(new tmp().solution(s));
	}

	// boolean solution(String s) {
	// boolean[] check = new boolean[256];
	// for (int i = 0; i < s.length(); i++) {
	// if (check[s.charAt(i)])
	// return false;
	// check[s.charAt(i)] = true;
	// }
	// return true;
	// }
	boolean solution(String s) {
		int checker = 0;
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i) - 'a';
			System.out.println(checker);
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}
}
