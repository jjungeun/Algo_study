import sys
sys.stdin = open("input.txt", "r")

import copy
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

def spread(room):
	new_room = [[0 for _ in range(C)] for _ in range(R)]
	for r in range(R):
		for c in range(C):
			if room[r][c] < 5:
				new_room[r][c] += room[r][c]
				continue
			spread_cnt = 0
			for i in range(4):
				nr, nc = r+dr[i], c+dc[i]
				if nr not in range(R) or nc not in range(C) or (nr,nc) in pos:
					continue
				new_room[nr][nc] += room[r][c] // 5
				spread_cnt += 1
			new_room[r][c] += room[r][c] - (room[r][c] // 5) * spread_cnt
	return new_room

def rotate(room, up, down):
	for i in range(1, len(up)+1):
		pre_r, pre_c = up[i-1]
		if i == len(up):
			room[pre_r][pre_c] = 0
		else:
			r, c = up[i]
			room[pre_r][pre_c] = room[r][c]
	for i in range(1, len(down)+1):
		pre_r, pre_c = down[i-1]
		if i == len(down):
			room[pre_r][pre_c] = 0
		else:
			r, c = down[i]
			room[pre_r][pre_c] = room[r][c]


def clean(room):
	up_pos, down_pos = pos[0][0], pos[1][0]
	up = []
	down = []
	for r in range(R):
		if r < up_pos:
			up = [(r, 0)] + up
		elif r > down_pos:
			down.append((r, 0))
	for c in range(1, C):
		up.append((0, c))
		down.append((R-1, c))
	for r in range(1, R):
		if r <= up_pos:
			up.append((r, C-1))
		elif r > down_pos:
			tmp_r = R - (r- down_pos) - 1
			down.append((tmp_r, C-1))
	for c in range(C-2, 0, -1):
		up.append((up_pos, c))
		down.append((down_pos, c))
	rotate(room, up, down)

R, C, T = map(int, input().split())
pos = []
room = []
for i in range(R):
	row = list(map(int, input().split()))
	room.append(row)
	if row[0] == -1:
		pos.append((i,0))
for _ in range(T):
	room = spread(room)
	clean(room)
answer = 0
for r in range(R):
	answer += sum(room[r])
print(answer+2)
