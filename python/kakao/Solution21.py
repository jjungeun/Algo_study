import sys

turn_dr = [-1, 0,1,0]
turn_dc = [0, 1,0,-1]

back_dr = [1,0,-1,0]
back_dc = [0,-1,0,1]

def solution(map_info, pos_info, area):
	answer = 1
	r, c, d = pos_info
	area[r][c] = 2
	N, M = map_info
	while True:
		tmp_d = d
		for i in range(4):
			tmp_d = (tmp_d + 3) % 4
			new_r, new_c = r + turn_dr[tmp_d], c + turn_dc[tmp_d]

			# a
			if new_r in range(0, N) and new_c in range(0, M) and area[new_r][new_c] == 0:
				area[new_r][new_c] = 2
				answer += 1
				r, c, d = new_r, new_c, tmp_d
				break
			# c
			if i == 3:
				new_r, new_c = r + back_dr[d], c + back_dc[d]
				r, c = new_r, new_c
				if new_r not in range(0, N) or new_c not in range(0, M) or area[new_r][new_c] == 1:
					return answer

if __name__ == "__main__":
	map_info = list(map(int, sys.stdin.readline().rstrip().split(' ')))
	pos_info = list(map(int, sys.stdin.readline().rstrip().split(' ')))
	area = []
	for row_idx in range(map_info[0]):
		area.append(list(map(int, sys.stdin.readline().rstrip().split(' '))))
	print(solution(map_info, pos_info, area))
