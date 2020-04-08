class Solution80 {
	public static void main(String[] args) {
		int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
		System.out.println(new Solution80().solution(land));
	}

	int dfs(int[][] land, int row, int sum, int max) {
		int tmp;
		if (land.length == row)
			return sum;
		for (int i = 0; i < 4; i++) {
			tmp = dfs(land, row + 1, sum + land[row][i], max);
			if (tmp > max)
				max = tmp;
		}
	}

	// dfs방식으로 풀기
	int solution(int[][] land) {
		int answer = dfs(land, 0, 0, 0);
		return answer;
	}
}
