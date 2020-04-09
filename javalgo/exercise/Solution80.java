class Solution80 {
	public static void main(String[] args) {
		int[][] land = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
		System.out.println(new Solution80().solution(land));
	}

	int solution(int[][] land) {
		int size = land.length;
		for (int i = 1; i < size; i++) {
			land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
			land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
			land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
			land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));
		}
		return Math.max(land[size - 1][0], Math.max(land[size - 1][1], Math.max(land[size - 1][2], land[size - 1][3])));
	}
}
