
class tmp {
	public static void main(String[] argv) {
		int[][] s = {{1,2,3},{3,2,1},{3,1,2}};
		int[][] arr = new tmp().solution(s);
		for(int[] i : arr)
		{
			for(int j: i)
				System.out.print(j + " ");
			System.out.println();
		}
	}


	int[][] solution(int[][] arr) {
		int[][] ret = new int[arr.length][arr.length];
		for(int row = 0; row<arr.length;row++)
			for(int col = 0; col<arr.length;col++)
				ret[(col+arr.length-1)%arr.length][row] = arr[row][col];
		return ret;
	}
}
