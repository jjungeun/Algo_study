import sys
from itertools import combinations
import copy

dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

def do_infect(area, pos, N, M):
	row, col = pos
	for i in range(4):
		new_row, new_col = row + dr[i], col + dc[i]
		if new_row in range(0, N) and new_col in range(0, M) and area[new_row][new_col] == 0:
			area[new_row][new_col] = 2
			do_infect(area, [new_row, new_col], N, M)

def get_area(area, new_wall, infect, N, M):
	tmp_area = copy.deepcopy(area)
	for wall in new_wall:
		r, c = wall
		tmp_area[r][c] = 1
	for infect_pos in infect:
		do_infect(tmp_area, infect_pos, N, M)
	return sum([tmp_area[r].count(0) for r in range(N)])

def solution(area, N, M):
	max_area = 0
	pos = []
	infect = []
	for r in range(N):
		for c in range(M):
			if area[r][c] == 0:
				pos.append([r,c])
			elif area[r][c] == 2:
				infect.append([r, c])
	walls = list(combinations(pos, 3))
	for new_wall in walls:
		max_area = max(max_area, get_area(area, new_wall, infect, N, M))
	return max_area

if __name__ == "__main__":
	N, M = map(int, input().split(' '))
	area = []
	for i in range(N):
		area.append(list(map(int,sys.stdin.readline().rstrip().split(' '))))
	print(solution(area, N, M))
