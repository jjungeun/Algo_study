import sys
sys.stdin = open("input.txt", "r")

import copy
dy = [1, -1, 0, 0]
dx = [0, 0, -1, 1]
def move(pos):
	new_pos = copy.deepcopy(pos)
	answer = 0
	pop_point = {}
	pre_point = {}
	pop_idx = []
	for key in pos.keys():
		x, y = pos[key]
		pre_point[(x, y)] = key
	for key in pos.keys():
		if key not in new_pos.keys():
			continue
		x, y = pos[key]
		d = direct[key]
		nx, ny = x+dx[d], y+dy[d]
		# 범위 벗어나면 지우기
		if nx not in range(-1000, 1001) or ny not in range(-1000, 1001):
			new_pos.pop(key)
			continue
		# 한점에서 만나는 경우
		if (nx, ny) in pop_point.keys():
			new_pos.pop(key)
			if pop_point[(nx,ny)] in new_pos.keys():
				new_pos.pop(pop_point[(nx, ny)])
				answer += energy[pop_point[(nx, ny)]]
			answer += energy[key]
			continue
		# 지나가다 만나는 경우(빗겨가는경우 조심)
		elif (nx, ny) in pre_point.keys():
			pre_idx = pre_point[(nx, ny)]
			pre_d = direct[pre_idx]
			pre_x, pre_y = nx+dx[pre_d], ny+dy[pre_d]
			if pre_x == x and pre_y == y:
				answer += energy[key]
				new_pos.pop(key)
				if pre_idx in new_pos.keys():
					new_pos.pop(pre_idx)
					answer += energy[pre_idx]
				continue
		pop_point[(nx, ny)] = key
		new_pos[key] = (nx, ny)
	return new_pos, answer

def simulation(pos):
	answer = 0
	for _ in range(2000):
		pos, pop = move(pos)
		answer += pop
	return answer

T = int(input())
for test_case in range(1, T + 1):
	N = int(input())
	pos = {}
	direct = []
	energy = []
	for i in range(N):
		x, y, d, k = map(int, input().split())
		pos[i] = (x,y)
		direct.append(d)
		energy.append(k)
	print("#%d %d" % (test_case, simulation(pos)))
