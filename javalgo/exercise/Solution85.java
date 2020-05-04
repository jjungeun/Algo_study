public class Solution85 {
	public static void main(String[] args)
	{
		System.out.println(new Solution85().solution(5000));
	}

	public int solution(int n) {
		int count = 0;
		while (n > 0)
		{
			if (n % 2 != 0) {
				count++;
				n -= 1;
			}
			n /= 2;
		}
		return count;
	}
}
