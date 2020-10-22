import java.util.HashSet;
import java.util.Iterator;

class Solution83 {
	public static void main(String[] args) {
		String numbers = "17";
		System.out.println(new Solution83().solution(numbers));
	}

	boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++)
			if (num % i == 0)
				return false;
		return num > 1 ? true : false;
	}

	void permutation(String prefix, String numbers, HashSet<Integer> set) {
		int n = numbers.length();
		if (!prefix.equals(""))
			set.add(Integer.valueOf(prefix));
		for (int i = 0; i<n; i++)
			permutation(prefix+numbers.charAt(i), numbers.substring(0, i)+numbers.substring(i+1, n), set);
	}

	public int solution(String numbers) {
		int answer = 0;
		HashSet<Integer> set = new HashSet<>();
		permutation("", numbers, set);
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext())
			if (isPrime(iter.next()))
				answer += 1;
		return answer;
	}
}
