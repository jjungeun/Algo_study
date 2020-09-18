from collections import deque

def init_board():
	board = [[0 for _ in range(N)] for _ in range(N)]
	for apple in apples:
		r, c = apple
		board[r-1][c-1] = 1
	return board

dr = [0,1,0,-1]
dc = [1,0,-1,0]
def go(board, snake, direct):
	nr, nc = snake[-1][0]+dr[direct], snake[-1][1]+dc[direct]
	# 벽에 닿으면 끝
	if nr not in range(0, N) or nc not in range(0, N):
		return False
	# 자기몸에 닿아도 끝
	if (nr, nc) in snake:
		return False
	# 사과 있으면 먹기
	if board[nr][nc] == 1:
		board[nr][nc] = 0
	else:
		snake.popleft()
	snake.append((nr, nc))
	return True

def do_game(board):
	snake = deque()
	snake.append((0,0))
	time = 1
	moves_idx = 0
	direct = 0
	while True:
		# (사과 먹으면 1증가)직진, 벽에 닿거나 자기몸에 닿으면 끝
		if not go(board, snake, direct):
			break
		# 방향전환
		if moves_idx < len(moves) and moves[moves_idx][0] == time:
			direct = (direct+1)%4 if moves[moves_idx][1] == 'D' else (direct-1)%4
			moves_idx += 1
		time += 1
	return time

N = int(input())
K = int(input())
apples = []
for _ in range(K):
	apples.append(tuple(map(int, input().split(' '))))
L = int(input())
moves = []
for _ in range(L):
	X, C = list(input().split(' '))
	moves.append((int(X), C))
board = init_board()
print(do_game(board))
