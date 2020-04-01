class Solution78 {
	public static void main(String[] args) {
		int[] stones = { 1, 3, 0, 1 };
		int k = 2;
		System.out.println(new Solution78().solution(stones, k));
	}

	public int solution(int[] stones, int k) {
		int[] max_cache = new int[stones.length];
		int answer = get_max(stones, 0, k + 1, max_cache);
		int max;
		for (int i = 0; i < stones.length - k; i++) {
			max = get_max(stones, i + 1, i + k + 1, max_cache);
			if (stones[i] > max && answer > max) {
				answer = max;
			}
		}
		return answer;
	}

	int get_max(int[] arr, int start, int end, int[] max_cache) {
		int max = 0;
		if (end > 2 && end - 2 < max_cache.length && start > 0 && max_cache[end - 2] > arr[start - 1]) {
			max = arr[end - 1] > max_cache[end - 2] ? arr[end - 1] : max_cache[end - 2];
		} else {
			for (int i = start; i < arr.length && i < end; i++) {
				if (arr[i] > max)
					max = arr[i];
			}
		}
		if (end - 1 < max_cache.length)
			max_cache[end - 1] = max;
		return (max);
	}
}
