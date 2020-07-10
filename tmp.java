
class tmp {
	public static void main(String[] argv) {

	}


	int[][] solution(int[][] arr) {
		int[][] ret = new int[arr.length][arr.length];
		for(int row = 0; row<arr.length;row++)
			for(int col = 0; col<arr.length;col++)
				ret[(col+arr.length-1)%arr.length][row] = arr[row][col];
		return ret;
	}
}
