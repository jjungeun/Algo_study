import sys
sys.stdin = open("input.txt", "r")

import copy
def catch(shark, pos):
	catch_size = 0
	neareast = R
	cathc_idx = -1
	for key in shark.keys():
		r, c = shark[key]
		if c == pos and r < neareast:
			catch_size = size[key]
			neareast = r
			cathc_idx = key
	if catch_size != 0:
		shark.pop(cathc_idx)
	return catch_size

dr = [-1, 1, 0, 0]
dc = [0, 0, 1, -1]
def move(shark):
	new_shark = copy.deepcopy(shark)
	new_pos = {}
	for key in shark.keys():
		r, c = shark[key]
		d = direct[key]
		for _ in range(speed[key]):
			nr, nc = r+dr[d], c+dc[d]
			if nr not in range(R) or nc not in range(C):
				direct[key] += 1 if d == 0 or d == 2 else -1
				d = direct[key]
				nr, nc = r+dr[d], c+dc[d]
			r, c = nr, nc
		# 상어가 있었던 경우
		if (r, c) in new_pos.keys():
			pre_idx, pre_size = new_pos[(r,c)]
			if pre_size > size[key]:
				new_shark.pop(key)
				continue
			else:
				new_shark.pop(pre_idx)
		new_pos[(r,c)] = [key, size[key]]
		new_shark[key] = (r, c)
	return new_shark

R, C, M = map(int, input().split())
shark = {}
speed = []
direct = []
size = []
for i in range(M):
	r, c, s, d, z = map(int, input().split())
	shark[i] = (r-1, c-1)
	speed.append(s)
	direct.append(d-1)
	size.append(z)
answer = 0
for pos in range(C):
	answer += catch(shark, pos)
	shark = move(shark)
print(answer)
