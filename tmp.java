import java.util.Arrays;

class tmp {
	public static void main(String[] argv) {
		String s1 = "cde";
		String s2 = "efd";
		System.out.println(new tmp().solution(s1, s2));
	}

	int[] get_numChar(String s){
		int[] numChar = new int[128];
		for(int i = 0; i < s.length(); i++)
			numChar[s.charAt(i)] += 1;
		return numChar;
	}

	boolean solution(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		return Arrays.equals(get_numChar(s1),get_numChar(s2));
	}
}
