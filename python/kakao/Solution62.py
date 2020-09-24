from collections import deque
dr = [-1, 0, 0, 1]
dc = [0, -1, 1, 0]
def get_near_fish(fishes, shark_pos, shark_size):
	dist = N * N
	mr, mc = N, N
	sr, sc = shark_pos
	q = deque()
	q.append((sr, sc, 0))
	visited = [[False for _ in range(N)] for _ in range(N)]
	visited[sr][sc] = True
	while q:
		r, c, d = q.popleft()
		if dist < d:
			continue
		if 0 < fishes[r][c] < shark_size and (r < mr or (r == mr and c < mc)):
			mr, mc = r, c
			dist = d
			continue
		for i in range(4):
			nr, nc = r+dr[i], c+dc[i]
			if nr not in range(0, N) or nc not in range(0, N):
				continue
			if not visited[nr][nc] and fishes[nr][nc] <= shark_size:
				q.append((nr, nc, d+1))
				visited[nr][nc] = True
	if mr in range(0, N) and mc in range(0, N):
		fishes[mr][mc] = 0
	return [mr, mc], dist

def eat_fish(N, fishes, shark_pos):
	answer = 0
	shark_size = 2
	cnt = 0
	while True:
		pos, dist = get_near_fish(fishes, shark_pos, shark_size)
		if pos == [N, N]:
			break
		answer += dist
		shark_pos = pos
		cnt += 1
		if cnt == shark_size:
			shark_size += 1
			cnt = 0
	return answer

N = int(input())
shark_pos = [0,0]
fishes = []
for r in range(N):
	row = list(map(int, input().split(' ')))
	if 9 in row:
		shark_pos = [r, row.index(9)]
		row[row.index(9)] = 0
	fishes.append(row)
print(eat_fish(N, fishes, shark_pos))
