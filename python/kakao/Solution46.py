from collections import deque
dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]

def solution(board):
	N = len(board)
	visited = [[-1 for _ in range(N)] for _ in range(N)]
	queue = deque()
	queue.append([0, 0, 0, 0])
	queue.append([0, 0, 1, 0])
	visited[0][0] = 0
	while len(queue) > 0:
		row, col, direct, cost = queue.popleft()
		for i in range(4):
			nr = row+dr[i]
			nc = col+dc[i]
			if nr in range(0, N) and nc in range(0, N) and not board[nr][nc] and abs(direct-i) != 2:
				new_cost = cost + 100 if direct == i else cost + 600
				if visited[nr][nc] == -1 or new_cost <= visited[nr][nc]:
					queue.append((nr, nc, i, new_cost))
					visited[nr][nc] = new_cost
	return visited[-1][-1]

board = [[0, 0, 0, 0, 0, 0], [0, 1, 1, 1, 1, 0], [0, 0, 1, 0, 0, 0], [1, 0, 0, 1, 0, 1], [0, 1, 0, 0, 0, 1], [0, 0, 0, 0, 0, 0]]
print(solution(board))
