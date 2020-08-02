from collections import deque

def solution(board):
	N = len(board)
	endpoint = (N-1, N-1)
	start = (0, 0, True)
	move_case = ((0, 1), (1, 0), (0, -1), (-1, 0))

	queue = deque([start])
	visited = set()
	visited.add(start)
	move_cnt = 0

	def _is_valid(row, col):
		if row in range(0, N) and col in range(0, N) and board[row][col] == 0:
			return True
		return False

	# 수평인경우
	def _yield_horizon_moves(row, col):
		# 상하좌우
		for m_row, m_col in move_case:
			new_row, new_col = row + m_row, col + m_col
			if _is_valid(new_row, new_col) and _is_valid(new_row, new_col+1):
				yield (new_row, new_col, True)
		# 밑으로 시계, 반시계
		if _is_valid(row+1,col) and _is_valid(row+1, col+1):
			yield (row, col, False)
			yield (row, col+1, False)
		# 위로 시계, 반시계
		if _is_valid(row-1, col) and _is_valid(row-1,col+1):
			yield (row-1, col, False)
			yield (row-1, col+1, False)

	# 수직인경우
	def _yield_vertical_moves(row, col):
		for m_row, m_col in move_case:
			new_row, new_col = row + m_row, col + m_col
			if _is_valid(new_row, new_col) and _is_valid(new_row+1, new_col):
				yield (new_row, new_col, False)
		if _is_valid(row, col-1) and _is_valid(row+1, col-1):
			yield (row+1, col-1, True)
			yield (row, col-1, True)
		if _is_valid(row, col+1) and _is_valid(row+1, col+1):
			yield (row, col, True)
			yield (row+1, col, True)

	while queue:
		move_cnt += 1
		for _ in range(len(queue)):
			row, col, is_horizon = queue.popleft()
			if is_horizon:
				yield_func = _yield_horizon_moves
			else:
				yield_func = _yield_vertical_moves

			for new_position in yield_func(row, col):
				if new_position not in visited:
					queue.append(new_position)
					visited.add(new_position)
					row, col, is_horizon = new_position
					if (row, col+1) == endpoint or (row+1, col) == endpoint:
						return move_cnt
	return move_cnt

board = [[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]
print(solution(board))
