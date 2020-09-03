from collections import deque

dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]

def add_riped(M, N, tomatos, q):
	for row in range(N):
		for col in range(M):
			if tomatos[row][col] == 1:
				q.append((row, col, 0))

def all_riped(M, N, tomatos):
	for row in range(N):
		for col in range(M):
			if tomatos[row][col] == 0:
				return False
	return True

def solution(M, N, tomatos):
	answer = 0
	q = deque()
	add_riped(M, N, tomatos, q)
	while len(q) > 0:
		row, col, day = q.popleft()
		answer = max(answer, day)
		for i in range(4):
			nr = row+dr[i]
			nc = col+dc[i]
			if nr not in range(0, N) or nc not in range(0, M):
				continue
			if tomatos[nr][nc] == 0:
				tomatos[nr][nc] = 1
				q.append((nr, nc, day+1))
	return answer if all_riped(M, N, tomatos) else -1

M, N = list(map(int, input().split(' ')))
tomatos = []
for _ in range(N):
	tomatos.append(list(map(int, input().split(' '))))
print(solution(M, N, tomatos))
