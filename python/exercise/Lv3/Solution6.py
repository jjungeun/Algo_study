def counting(m, n, board, top):
	count = [[0 for _ in range(n)] for _ in range(m)]
	for c in range(1, n):
		for r in range(top[c] + 1, m):
			if board[r][c] == 'a':
				continue
			block = 1 if board[r-1][c-1] == board[r][c] else 0
			block += 1 if board[r-1][c] == board[r][c] else 0
			block += 1 if board[r][c-1] == board[r][c] else 0
			count[r][c] = block
			if block == 3:
				count[r-1][c-1] = 3
				count[r-1][c] = 3
				count[r][c-1] = 3
	return count

def poping(m, n, count, board, top):
	new_col = ["" for _ in range(n)]
	for c in range(n):
		tmp_col = ""
		for r in range(top[c], m):
			if count[r][c] == 3:
				top[c] += 1
			else:
				tmp_col += board[r][c]
		new_col[c] = "a" * top[c] + tmp_col
	new_board = ["" for _ in range(m)]
	for c in range(n):
		for r in range(m):
			new_board[r] += new_col[c][r]
	return new_board

def isdone(m, n, count):
	for r in range(m):
		for c in range(n):
			if count[r][c] == 3:
				return False
	return True

def solution(m, n, board):
	answer = 0
	top = [0 for _ in range(n)]
	while True:
		count = counting(m, n, board, top)
		if isdone(m, n, count):
			break
		board = poping(m, n, count, board, top)
	return sum(top)

m = 4
n = 5
board = ["CCBDE", "AAADE", "AAABF", "CCBBF"]
print(solution(m, n, board))
