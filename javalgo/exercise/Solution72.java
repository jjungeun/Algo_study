import java.util.Stack;

class Solution72 {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		System.out.println(new Solution72().solution(board, moves));
	}

	int get_row(int[][] board, int col) {
		for (int row = 0; row < board.length; row++) {
			if (board[row][col] != 0)
				return row;
		}
		return -1;
	}

	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i : moves) {
			int col = i - 1;
			int row = get_row(board, col);
			if (row >= 0) {
				int tmp = board[row][col];
				board[row][col] = 0;
				if (!stack.empty() && stack.peek() == tmp) {
					answer += 2;
					stack.pop();
				} else
					stack.push(tmp);
			}
		}
		return answer;
	}
}
