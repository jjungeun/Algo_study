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
			if _is_valid(new_row, new_col) and _is_valid(new_row+1, col):
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

# def is_finish(position, N):
# 	row, col, is_horizon = position
# 	if is_horizon == True and row == N - 1 and col == N - 2:
# 		return True
# 	if is_horizon == False and row == N - 2 and col == N - 1:
# 		return True
# 	return False

# def is_invalid(board, position, N):
# 	row, col, is_horizon = position
# 	if is_horizon:
# 		if row not in range(0, N) or col not in range(0, N - 1):
# 			return True
# 		if board[row][col] == 1 or board[row][col + 1] == 1:
# 			return True
# 	else:
# 		if row not in range(0, N - 1) or col not in range(0, N):
# 			return True
# 		if board[row][col] == 1 or board[row + 1][col] == 1:
# 			return True
# 	return False

# def test_cases(board, position, move, min_move):
# 	row, col, is_horizon = position
# 	N = len(board)
# 	if is_invalid(board, position, N):
# 		return N * N
# 	if is_finish(position, N) or move > min_move:
# 		return move
# 	min_move = min(min_move, test_cases(board, [row, col + 1, is_horizon], move + 1, min_move))
# 	# min_move = min(min_move, test_cases(board, [row, col - 1, is_horizon], move + 1, min_move))
# 	min_move = min(min_move, test_cases(board, [row + 1, col, is_horizon], move + 1, min_move))
# 	# min_move = min(min_move, test_cases(board, [row - 1, col, is_horizon], move + 1, min_move))
# 	if is_horizon:
# 		if col + 1 < N and row + 1 < N and board[row + 1][col + 1] == 0:
# 			min_move = min(min_move, test_cases(board, [row, col, not is_horizon], move + 1, min_move))
# 		if row - 1 >= 0 and board[row - 1][col] == 0:
# 			min_move = min(min_move, test_cases(board, [row - 1, col + 1, not is_horizon], move + 1, min_move))
# 		# if row + 1 < N and board[row + 1][col] == 0:
# 		# 	min_move = min(min_move, test_cases(board, [row, col + 1, not is_horizon], move + 1, min_move))
# 		# if row - 1 >= 0 and col + 1 < N and board[row - 1][col + 1] == 0:
# 		# 	min_move = min(min_move, test_cases(board, [row - 1, col, not is_horizon], move + 1, min_move))
# 	else:
# 		if col + 1 < N and board[row][col + 1] == 0:
# 			min_move = min(min_move, test_cases(board, [row + 1, col, not is_horizon], move + 1, min_move))
# 		if col - 1 >= 0 and row + 1 < N and board[row + 1][col - 1] == 0:
# 			min_move = min(min_move, test_cases(board, [row, col - 1, not is_horizon], move + 1, min_move))
# 		# if col - 1 >= 0 and board[row][col - 1] == 0:
# 		# 	min_move = min(min_move, test_cases(board, [row + 1, col - 1, not is_horizon], move + 1, min_move))
# 		# if row + 1 < N and col + 1 < N and board[row + 1][col + 1] == 0:
# 		# 	min_move = min(min_move, test_cases(board, [row, col, not is_horizon], move + 1, min_move))
# 	return min_move

# def solution(board):
# 	N = len(board)
# 	return test_cases(board, [0, 0, True], 0, N * N)
