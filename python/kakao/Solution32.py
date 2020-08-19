def no_box(board, end_row, col):
	for row in range(end_row):
		if board[row][col] != 0:
			return 0
	return 1

def can_pop(board, N, row, col):
	value = board[row][col]
	if row+2 < N and col+1 < N and board[row+1][col]==value and board[row+2][col]==value and board[row+2][col+1]==value:
		if no_box(board, row+2, col+1):
			return 1
	elif row+1 < N and col+2 < N and board[row+1][col]==value and board[row+1][col+1] == value and board[row+1][col+2] == value:
		if no_box(board, row+1, col+1) and no_box(board, row+1, col+2):
			return 1
	elif row+1 < N and col-2 >= 0 and board[row+1][col-2] == value and board[row+1][col-1] == value and board[row+1][col]==value:
		if no_box(board, row+1, col-2) and no_box(board, row+1, col-1):
			return 1
	elif row+2 < N and col-1 >= 0 and board[row+2][col-1] == value and board[row+2][col]==value and board[row+1][col] == value:
		if no_box(board, row+2, col-1):
			return 1
	elif row+1 < N and col-1 >= 0 and col+1 < N and board[row+1][col-1] == value and board[row+1][col]==value and board[row+1][col+1] == value:
		if no_box(board, row+1, col-1) and no_box(board, row+1, col+1):
			return 1
	return 0

def do_pop(board, N, value):
	cnt = 0
	for i in range(N):
		for j in range(N):
			if board[i][j] == value:
				cnt += 1
				board[i][j] = 0
				if cnt == 4:
					return

def solution(board):
	answer = 0
	N = len(board)
	while True:
		cnt = 0
		check = set()
		for row in range(N):
			for col in range(N):
				if board[row][col] != 0 and board[row][col] not in check:
					check.add(board[row][col])
					if can_pop(board, N, row, col):
						do_pop(board, N, board[row][col])
						cnt += 1
		if cnt == 0:
			break
		answer += cnt
	return answer


board = [[0,0,0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,4,0,0,0],
[0,0,0,0,0,4,4,0,0,0],
[0,0,0,0,3,0,4,0,0,0],
[0,0,0,2,3,0,0,0,5,5],
[1,2,2,2,3,3,0,0,0,5],
[1,1,1,0,0,0,0,0,0,5]]
print(solution(board))
