class Solution71 {
	public static void main(String[] args) {
		int n = 2;
		// String[] data = { "M~C<2", "C~M>1" };
		String[] data = { "N~F=0", "R~T>2" };
		System.out.println(new Solution71().solution(n, data));
	}

	boolean check(String str, String[] data, int n) {
		for (int i = 0; i < n; i++) {
			String c1 = Character.toString(data[i].charAt(0));
			String c2 = Character.toString(data[i].charAt(2));
			if (str.contains(c1) && str.contains(c2)) {
				int interval = Math.abs(str.indexOf(data[i].charAt(0)) - str.indexOf(data[i].charAt(2))) - 1;
				if (data[i].charAt(3) == '=' && interval != data[i].charAt(4) - '0')
					return false;
				else if (data[i].charAt(3) == '<' && interval >= data[i].charAt(4) - '0')
					return false;
				else if (data[i].charAt(3) == '>' && interval <= data[i].charAt(4) - '0') {
					return false;
				}
			}
		}
		return true;
	}

	int permutation(String prefix, String str, String[] data, int n, int count) {
		int ret = 0;

		if (str.length() == 0)
			return 1;
		for (int i = 0; i < str.length(); i++) {
			String rem = str.substring(0, i) + str.substring(i + 1);
			if (check(prefix + str.charAt(i), data, n))
				ret += permutation(prefix + str.charAt(i), rem, data, n, count);
		}
		return ret;
	}

	public int solution(int n, String[] data) {
		int answer = 0;
		// char[] people = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
		// String people = "ACFJ";
		String people = "ACFJMNRT";
		answer = permutation("", people, data, n, 0);
		return answer;
	}
}
