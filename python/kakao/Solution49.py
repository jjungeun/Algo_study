from collections import deque
dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]

htr = [-1, 0, -1, 0]
htc = [0, 0, 1, 1]
hcr = [0, 1, 0, 1]
hcc = [1, 1, -1, -1]

vtr = [0, 0, 1, 1]
vtc = [-1, 0, -1, 0]
vcr = [1, 1, -1, -1]
vcc = [0, 1, 0, 1]

def is_arrive(N, row, col, is_horizon):
	if is_horizon and row == N-1 and col == N-2:
		return True
	elif not is_horizon and row == N-2 and col == N-1:
		return True
	return False

def in_range(N, nr, nc, is_horizon):
	if is_horizon:
		if nr in range(0, N) and nc in range(0, N-1):
			return True
	else:
		if nr in range(0, N-1) and nc in range(0, N):
			return True
	return False

def can_go(board, nr, nc, is_horizon):
	if is_horizon:
		if board[nr][nc] == 0 and board[nr][nc+1] == 0:
			return True
	else:
		if board[nr][nc] == 0 and board[nr+1][nc] == 0:
			return True
	return False

def solution(board):
	answer = float('inf')
	N = len(board)
	visited = set()
	queue = deque()
	queue.append((0, 0, True, 0))
	visited.add((0, 0, True))
	while queue:
		row, col, is_horizon, time = queue.popleft()
		# 끝인지 확인
		if is_arrive(N, row, col, is_horizon):
			answer = min(answer, time)
			break
		# 상하좌우로 움직이는경우
		for i in range(4):
			nr, nc = row+dr[i], col+dc[i]
			if in_range(N, nr, nc, is_horizon) and can_go(board, nr, nc, is_horizon) and (nr, nc, is_horizon) not in visited:
				queue.append((nr, nc, is_horizon, time+1))
				visited.add((nr, nc, is_horizon))
		# 회전하는경우
		tr, tc = [htr, htc] if is_horizon else [vtr, vtc]
		cr, cc = [hcr, hcc] if is_horizon else [vcr, vcc]
		for i in range(4):
			nr, nc, nd = row+tr[i], col+tc[i], not is_horizon
			r, c = nr+cr[i], nc+cc[i]
			if in_range(N, nr, nc, nd) and can_go(board, nr, nc, nd) and (nr, nc, nd) not in visited:
				if board[r][c] == 0:
					queue.append((nr, nc, nd, time+1))
					visited.add((nr, nc, nd))
	return answer


board = [[0, 0, 0, 1, 1],[0, 0, 0, 1, 0],[0, 1, 0, 1, 1],[1, 1, 0, 0, 1],[0, 0, 0, 0, 0]]
print(solution(board))
