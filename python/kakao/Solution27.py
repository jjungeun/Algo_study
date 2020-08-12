from itertools import combinations
import copy

def init_cctv_pos():
	cctv_dict = {}
	for i in range(1, 5):
		cctv_idx = list(combinations([0,1,2,3], i))
		cctv_direct = []
		for c_idx in cctv_idx:
			tmp = []
			for idx in range(4):
				tmp += [1] if idx in c_idx else [0]
			cctv_direct.append(tmp)
		if i == 1:
			cctv_dict[i] = cctv_direct
		elif i == 2:
			cctv_dict[i] = [[1,0,1,0],[0,1,0,1]]
			cctv_direct.remove([1,0,1,0])
			cctv_direct.remove([0,1,0,1])
			cctv_dict[i + 1] = cctv_direct
		else:
			cctv_dict[i + 1] = cctv_direct
	return cctv_dict

def get_cctv_pos(office):
	cctv_pos = []
	for row in range(N):
		for col in range(M):
			if office[row][col] in cctv_dict.keys():
				cctv_pos.append([row, col, office[row][col]])
	return cctv_pos

def count_watch(office):
	count = 0
	for row_idx in range(N):
		count += office[row_idx].count(0)
	return count

def watch(office, row, col, direct):
	if direct[0] == 1:
		for row_idx in range(row-1, -1, -1):
			if office[row_idx][col] == 6:
				break
			elif office[row_idx][col] == 0:
				office[row_idx][col] = 7
	if direct[2] == 1:
		for row_idx in range(row+1, N):
			if office[row_idx][col] == 6:
				break
			elif office[row_idx][col] == 0:
				office[row_idx][col] = 7
	if direct[1] == 1:
		for col_idx in range(col+1, M):
			if office[row][col_idx] == 6:
				break
			elif office[row][col_idx] == 0:
				office[row][col_idx] = 7
	if direct[3] == 1:
		for col_idx in range(col-1, -1, -1):
			if office[row][col_idx] == 6:
				break
			elif office[row][col_idx] == 0:
				office[row][col_idx] = 7
	return office

def max_watch(office, cctv_dict, cctv_pos, idx):
	answer = N * M
	if len(cctv_pos) == idx:
		return count_watch(office)
	row, col, cctv_num = cctv_pos[idx]
	for direct in cctv_dict[cctv_num]:
		tmp_office = watch(copy.deepcopy(office), row, col, direct)
		answer = min(answer, max_watch(tmp_office, cctv_dict, cctv_pos, idx+1))
	return answer

N, M = list(map(int, input().split(' ')))
office = []
for _ in range(N):
	office.append(list(map(int, input().split(' '))))
cctv_dict = init_cctv_pos()
cctv_pos = get_cctv_pos(office)
print(max_watch(office, cctv_dict, cctv_pos, 0))
