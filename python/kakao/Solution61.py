from collections import deque

dr = [-1,  0, 0, 1]
dc = [0, -1, 1, 0]

def get_dist(taxi_map, start_pos, end_pos):
	sr, sc = start_pos
	er, ec = end_pos
	dist = -1
	visited = [[False for _ in range(N)] for _ in range(N)]
	visited[sr][sc] = True
	q = deque()
	q.append((sr, sc, 0))
	while q:
		r, c, d = q.popleft()
		if (r, c) == (er, ec):
			dist = d
			break
		for i in range(4):
			nr, nc = r+dr[i], c+dc[i]
			if nr not in range(0, N) or nc not in range(0, N):
				continue
			if taxi_map[nr][nc] == 0 and not visited[nr][nc]:
				q.append((nr, nc, d+1))
				visited[nr][nc] = True
	return dist

def find_guest(taxi_map, taxi_pos, guests):
	tr, tc = taxi_pos
	min_dist = N * N
	min_idx = -1
	mr, mc = N, N
	visited = [[False for _ in range(N)] for _ in range(N)]
	visited[tr][tc] = True
	q = deque()
	q.append((tr, tc, 0))
	while q:
		r, c, d = q.popleft()
		if d > min_dist:
			continue
		if guests_pos[r][c] != -1 and (r < mr or (r == mr and c < mc)):
			min_idx = guests_pos[r][c]
			min_dist = d
			mr, mc = r, c
			continue
		for i in range(4):
			nr, nc = r+dr[i], c+dc[i]
			if nr not in range(0, N) or nc not in range(0, N):
				continue
			if taxi_map[nr][nc] == 0 and not visited[nr][nc]:
				q.append((nr, nc, d+1))
				visited[nr][nc] = True
	if mr in range(0, N) and mc in range(0, N):
		guests_pos[mr][mc] = -1
	return min_idx, min_dist

def do_work(taxi_map, fuel, taxi_pos, guests):
	answer = fuel
	cnt = 0
	while cnt < len(guests):
		# 가장 가까이 있는 승객 찾기
		idx, to_guest_dist = find_guest(taxi_map, taxi_pos, guests)
		# 승객까지 못가는 경우
		if idx == -1:
			answer = -1
			break
		answer -= to_guest_dist
		start, end = guests[idx]
		# 승객 시작에서 도착지까지 거리
		to_end_dist = get_dist(taxi_map, start, end)
		answer -= to_end_dist
		# 연료가 떨어졌거나 도착지로 못가는 경우
		if answer < 0 or to_end_dist == -1:
			answer = -1
			break
		# 택시 위치 업데이트
		taxi_pos = end
		answer += to_end_dist * 2
		cnt += 1
	return answer

N, M, fuel = map(int, input().split(' '))
taxi_map = []
for _ in range(N):
	taxi_map.append(list(map(int, input().split(' '))))
taxi_pos = map(int, input().split(' '))
taxi_pos = [pos-1 for pos in taxi_pos]
guests = []
for _ in range(M):
	sr, sc, er, ec = map(int, input().split(' '))
	guests.append([[sr-1, sc-1], [er-1, ec-1]])
guests_pos = [[-1 for _ in range(N)] for _ in range(N)]
for idx, guest in enumerate(guests):
	start, end = guest
	sr, sc = start
	guests_pos[sr][sc] = idx
print(do_work(taxi_map, fuel, taxi_pos, guests))
