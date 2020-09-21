import copy
# 오른쪽, 아래, 왼쪽, 위에
d_check = [(0, -1),(-1, 0),(0, 1), (1, 0)]
d = [(0, 1), (1, 0),(0, -1),(-1, 0)]

def get_max(board, N):
	max_value = 0
	for r in range(N):
		max_value = max(max_value, max(board[r]))
	return max_value

# 오른쪽, 아래면 끝열부터, 왼쪽, 위면 원래대로
def move(board, N, direct, is_reverse):
	new_board = copy.deepcopy(board)
	range_ord = range(N-1, -1, -1) if is_reverse else range(N)
	for r in range_ord:
		for c in range_ord:
			if new_board[r][c] == 0:
				continue
			# 앞에 같은게 있으면 합치고 그자리는 0으로
			nr, nc = r, c
			while True:
				nr, nc = nr+d_check[direct][0], nc+d_check[direct][1]
				if nr not in range(0, N) or nc not in range(0, N):
					break
				if new_board[nr][nc] != 0:
					if new_board[nr][nc] == new_board[r][c]:
						new_board[r][c] *= 2
						new_board[nr][nc] = 0
					break
			# 앞에 없으면 있을때까지 땡기기
			nr, nc = r, c
			while True:
				tmp_r, tmp_c = nr+d[direct][0], nc+d[direct][1]
				if tmp_r not in range(0, N) or tmp_c not in range(0, N):
					break
				if new_board[tmp_r][tmp_c] != 0:
					break
				nr, nc = tmp_r, tmp_c
			if nr != r or nc != c:
				new_board[nr][nc] = new_board[r][c]
				new_board[r][c] = 0
	return new_board

def do_game(board, N, depth):
	answer = 0
	if depth == 5:
		return get_max(board, N)
	for direct in range(4):
		new_board = move(board, N, direct, direct < 2)
		answer = max(answer, do_game(new_board, N, depth+1))
	return answer

N = int(input())
board = []
for _ in range(N):
	board.append(list(map(int, input().split(' '))))
print(do_game(board, N, 0))

