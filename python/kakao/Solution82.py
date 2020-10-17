import sys
sys.stdin = open("input.txt", "r")

from collections import deque
dr = [-1, 0, 0, 1]
dc = [0, -1, 1, 0]
def get_neareast(taxi, fuel):
	min_dist = N * N
	min_r, min_c = -1, -1
	r, c = taxi[0], taxi[1]
	q = deque()
	visited = [[False for _ in range(N)] for _ in range(N)]
	q.append((r, c, 0))
	visited[r][c] = True
	while q:
		r, c, dist = q.popleft()
		if dist > min_dist:
			break
		if (r, c) in start.keys():
			if dist < min_dist or r < min_r or (r == min_r and c < min_c):
				min_dist = dist
				min_r, min_c = r, c
			continue
		for i in range(4):
			nr, nc = r+dr[i], c+dc[i]
			if nr not in range(N) or nc not in range(N) or visited[nr][nc] or board[nr][nc] == 1:
				continue
			q.append((nr, nc, dist+1))
			visited[nr][nc] = True
	return (min_r, min_c), min_dist

def go_goal(spos, epos, fuel):
	sr, sc = spos
	q = deque()
	q.append((sr, sc, 0))
	visited = [[False for _ in range(N)] for _ in range(N)]
	visited[sr][sc] = True
	while q:
		r, c, dist = q.popleft()
		if (r, c) == epos:
			return dist
		if dist+1 > fuel:
			break
		for i in range(4):
			nr, nc = r+dr[i], c+dc[i]
			if nr not in range(N) or nc not in range(N) or visited[nr][nc] or board[nr][nc] == 1:
				continue
			q.append((nr, nc, dist+1))
			visited[nr][nc] = True
	return -1

N, M, fuel = map(int, input().split())
board = []
for _ in range(N):
	board.append(list(map(int, input().split())))
taxi = tuple(map(int, input().split()))
taxi = (taxi[0]-1, taxi[1]-1)
start = {}
end = []
for i in range(M):
	sr, sc, er, ec = map(int, input().split())
	start[(sr-1, sc-1)] = i
	end.append((er-1, ec-1))

while len(start) > 0:
	pos, dist = get_neareast(taxi, fuel)
	if dist == N*N:
		fuel = -1
		break
	pidx = start[pos]
	fuel -= dist
	dist = go_goal(pos, end[pidx], fuel)
	if dist == -1:
		fuel = -1
		break
	fuel += dist
	taxi = end[pidx]
	start.pop(pos)
print(fuel)
