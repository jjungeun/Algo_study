public class Solution88 {
	public static void main(String[] args)
	{
		int m = 2;
		int n = 2;
		String board[] = {"AA","AB"};
		// System.out.println(new Solution88().solution(m,n,board));
		System.out.println(new Solution88().solution(6,2, new String[] {"AA", "AA", "CC", "AA", "AA", "DD"}));
	}

	int left_new_row(int[][] check, int new_row, int col)
	{
		int left_new_row = -1;
		for(int r = new_row; r >= 0; r--)
		{
			if (check[r][col - 1] == 0)
			{
				left_new_row = r;
				break ;
			}
		}
		return left_new_row;
	}

	int diagonal_new_row(int[][] check, int new_row, int col)
	{
		int diagonal_new_row = -1;
		boolean is_first = true;
		for(int r = new_row; r >= 0; r--)
		{
			if (check[r][col - 1] == 0)
			{
				if(is_first)
					is_first = false;
				else
				{
					diagonal_new_row = r;
					break;
				}
			}
		}
		return diagonal_new_row;
	}

	int up_new_row(int[][] check, int new_row, int col)
	{
		int up_new_row = -1;
		for(int r = new_row - 1; r >= 0; r--)
		{
			if (check[r][col] == 0)
			{
				up_new_row = r;
				break ;
			}
		}
		return up_new_row;
	}

	int tmp_to_check(int[][] check, int[][] tmp, int m, int n)
	{
		int num = 0;
		for(int new_row = 0; new_row < m; new_row++)
			for(int col = 0; col < n; col++)
			{
				if(tmp[new_row][col] == 1 && check[new_row][col] != 1)
				{
					check[new_row][col] = 1;
					num++;
				}
			}
		return num;
	}

	int get_new_row(int[][] check, int r, int col)
	{
		int new_row = r;
		for (int i = r + 1; i < check.length; i++)
			if(check[i][col] != 0)
				new_row++;
		return new_row;
	}

	public int solution(int m, int n, String[] board) {
		int answer = 0;
		int[][] check = new int[m][n];
		while (true)
		{
			int[][] tmp = new int[m][n];
			int pop_num = 0;
			for (int row = 0; row < m; row++)
				for (int col = 1; col < n; col++)
				{
					int new_row = get_new_row(check, row, col);
					if(left_new_row(check, new_row, col) != -1 && diagonal_new_row(check, new_row, col) != -1 && up_new_row(check, row, col) != -1)
					{
						char c = board[row].charAt(col);
						if (c == board[left_new_row(check, new_row, col)].charAt(col-1)&& c == board[diagonal_new_row(check, new_row, col)].charAt(col-1)
						&& c == board[up_new_row(check, row, col)].charAt(col))
						{
							tmp[row][col] = 1;
							tmp[left_new_row(check, new_row, col)][col - 1] = 1;
							tmp[diagonal_new_row(check, new_row, col)][col - 1] = 1;
							tmp[up_new_row(check, row, col)][col] = 1;
						}
					}
				}
			if ((pop_num = tmp_to_check(check, tmp, m, n)) == 0)
				break;
			answer += pop_num;
		}
        return answer;
    }
}
