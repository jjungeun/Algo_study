class Solution79 {
	public static void main(String[] args) {
		int n = 78;
		System.out.println(new Solution79().solution(n));
	}

	int getOneCount(int n) {
		int count = 0;
		while (n != 0) {
			count += n % 2 == 1 ? 1 : 0;
			n /= 2;
		}
		return count;
	}

	public int solution(int n) {
		int oneCount = getOneCount(n);
		while (true) {
			n++;
			if (getOneCount(n) == oneCount)
				break;
		}
		return n;
	}
}
