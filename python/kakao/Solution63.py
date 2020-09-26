from itertools import combinations
import copy
from collections import deque
dr = [1, 0, -1, 0]
dc = [0, 1, 0, -1]

def get_time(bpos,bmap):
	q = deque()
	max_time = 0
	bvisited = set()
	all_spread = False
	for b in bpos:
		r, c = b
		q.append([r, c, 0])
		bvisited.add((r, c))
	while q:
		r, c, time = q.popleft()
		if bmap[r][c] != 0:
			max_time = max(max_time, time)
		for i in range(4):
			nr, nc = r+dr[i], c+dc[i]
			if nr not in range(0, N) or nc not in range(0, N):
				continue
			if bmap[nr][nc] == -1:
				q.append([nr, nc, time+1])
				bmap[nr][nc] = time+1
			elif bmap[nr][nc] == 0 and (nr, nc) not in bvisited:
				q.append([nr, nc, time+1])
				bvisited.add((r, c))
	for b in bmap:
		if -1 in b:
			return N * N
	return max_time

def spread(bmap, bpos):
	bcomb = list(combinations(bpos, M))
	min_time = N * N
	for comb in bcomb:
		min_time = min(min_time, get_time(comb, copy.deepcopy(bmap)))
	return min_time if min_time < N * N else -1

N, M = map(int, input().split(' '))
bmap = []
bpos = []
for r in range(N):
	tmp = list(map(int, input().split(' ')))
	row = []
	for c in range(N):
		if tmp[c] == 2:
			bpos.append([r, c])
			row.append(0)
		elif tmp[c] == 0:
			row.append(-1)
		else:
			row.append(-2)
	bmap.append(row)
print(spread(bmap, bpos))
