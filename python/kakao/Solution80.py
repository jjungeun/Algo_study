import sys
sys.stdin = open("input.txt", "r")

from collections import deque
import copy
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
def open_cnt(visited):
	is_changed = False
	for r in range(N):
		for c in range(N):
			if visited[r][c]:
				continue
			visited[r][c] = True
			q = deque()
			union = deque()
			q.append((r, c))
			union.append((r,c))
			cnt = 1
			people_sum = people[r][c]
			while q:
				row, col = q.popleft()
				for i in range(4):
					nr, nc = row+dr[i], col+dc[i]
					if nr not in range(N) or nc not in range(N) or visited[nr][nc]:
						continue
					diff = abs(people[row][col] - people[nr][nc])
					if L <= diff <= R:
						visited[nr][nc] = True
						q.append((nr, nc))
						union.append((nr, nc))
						cnt += 1
						people_sum += people[nr][nc]
						is_changed = True
			if is_changed:
				union_people = people_sum // cnt
				for nation in union:
					row, col = nation
					people[row][col] = union_people
	return is_changed


N, L, R = map(int, input().split())
people = []
for _ in range(N):
	people.append(list(map(int, input().split())))
answer = 0
while True:
	visited = [[False for _ in range(N)] for _ in range(N)]
	if not open_cnt(visited):
		break
	answer += 1
print(answer)
