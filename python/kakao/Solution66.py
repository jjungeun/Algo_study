from collections import defaultdict, deque

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
def move():
	global time
	for n in range(1, M+1):
		if n not in alive_shark:
			if len(shark_pos[n]) > 0 and time - shark_pos[n][0][3] == K:
				shark_pos[n].popleft()
			continue
		# 아직 상어가 남아있으면 움직이기
		r, c, d, t = shark_pos[n][-1]
		rule = shark_rule[n][d-1]
		nr, nc, new_d = -1, -1, -1
		is_mine = False
		for i in rule:
			tr, tc = r+dr[i-1], c+dc[i-1]
			if tr not in range(N) or tc not in range(N):
				continue
			# if n == 2:
			# 	print(i)
			# 	print(tr, tc, sea[tr][tc])
			# 냄새없는 칸으로 가는 경우
			if sea[tr][tc] == 0:
				nr, nc, new_d = tr, tc, i
				break
			# 자신의 냄새가 있는 방향으로 가는 경우
			if sea[tr][tc] == n and not is_mine:
				nr, nc, new_d = tr, tc, i
				is_mine = True
		shark_pos[n].append((nr, nc, new_d, time))
		if len(shark_pos[n]) > K:
			shark_pos[n].popleft()
	new_sea = [[0 for _ in range(N)] for _ in range(N)]
	for n in range(1, M+1):
		if len(shark_pos[n]) == 0:
			continue
		r, c, d, t = shark_pos[n][-1]
		# 쫒겨나는 경우
		if n in alive_shark and new_sea[r][c] != 0:
			alive_shark.remove(n)
			shark_pos[n].pop()
		poses = shark_pos[n]
		for i, pos in enumerate(poses):
			pr, pc, pd, pt = pos
			new_sea[pr][pc] = n
	return new_sea


N, M, K = map(int, input().split())
shark_pos = defaultdict(list)
sea = [list(map(int, input().split())) for _ in range(N)]
shark_direct = list(map(int, input().split()))
shark_rule = defaultdict(dict)
alive_shark = set(i for i in range(1, M+1))

for r in range(N):
	line = sea[r]
	for c in range(N):
		idx = line[c]
		if idx != 0:
			shark_pos[idx] = deque([(r, c, shark_direct[idx-1], 1)])

for shark in range(1,M+1):
	for n in range(4):
		shark_rule[shark][n] = list(map(int, input().split()))

time = 1
while True:
	time += 1
	if time > 1001:
		print(-1)
		break
	sea = move()
	if len(alive_shark) == 1:
		print(time-1)
		break
