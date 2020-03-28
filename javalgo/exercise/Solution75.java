class Solution75 {
	public static void main(String[] args) {
		int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
		int k = 3;
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
		for (int i = start; i < end; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return (max);
	}

	// boolean is_end(int[] stones, int k) {
	// int sigh = 0;
	// for (int s : stones) {
	// if (s == 0)
	// sigh++;
	// else
	// sigh = 0;
	// if (sigh >= k)
	// return (true);
	// }
	// return (false);
	// }

	// int get_min(int[] arr) {
	// int min = 200000000;
	// for (int i = 0; i < arr.length; i++) {
	// if (arr[i] != 0 && arr[i] < min)
	// min = arr[i];
	// }
	// return (min);
	// }

	// public int solution(int[] stones, int k) {
	// int answer = 0;
	// while (true) {
	// if (is_end(stones, k))
	// break;
	// int min = get_min(stones);
	// for (int i = 0; i < stones.length; i++) {
	// if (stones[i] - min > 0)
	// stones[i] -= min;
	// else
	// stones[i] = 0;
	// }
	// answer += min;
	// }
	// return answer;
	// }
}
