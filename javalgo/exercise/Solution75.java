class Solution75 {
	public static void main(String[] args) {
		int[] stones = { 1, 5 };
		int k = 1;
		System.out.println(new Solution75().solution(stones, k));
	}

	public int solution(int[] stones, int k) {
		int answer = get_max(stones, 0, k + 1);
		int max;
		for (int i = 0; i < stones.length - k; i++) {
			max = get_max(stones, i + 1, i + k + 1);
			if (stones[i] > max && answer > max) {
				answer = max;
			}
		}
		return answer;
	}

	int get_max(int[] arr, int start, int end) {
		int max = 0;
		for (int i = start; i < arr.length && i < end; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return (max);
	}
}
