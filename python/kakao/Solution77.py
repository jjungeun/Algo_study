import sys
sys.stdin = open("input.txt", "r")

from collections import defaultdict
def r_cal(array, rlen, clen):
	max_len = 0
	for r in range(rlen):
		new_row = []
		cnt = defaultdict(int)
		for c in range(clen):
			v = array[r][c]
			if v != 0:
				cnt[v] += 1
		sort_cnt = sorted(cnt.items(), key=lambda k: (k[1], k[0]))
		for num in sort_cnt:
			new_row.extend([num[0], num[1]])
			if len(new_row) >= 100:
				break
		array[r] = new_row
		max_len = max(max_len, len(new_row))
	for r in range(rlen):
		ext_len = max_len - len(array[r])
		if ext_len > 0:
			array[r] += [0 for _ in range(ext_len)]
	return array

def l_cal(array, rlen, clen):
	max_len = 0
	new_array = []
	for c in range(clen):
		new_col = []
		cnt = defaultdict(int)
		for r in range(rlen):
			v = array[r][c]
			if v != 0:
				cnt[v] += 1
		sort_cnt = sorted(cnt.items(), key=lambda k: (k[1], k[0]))
		for num in sort_cnt:
			new_col.extend([num[0], num[1]])
			if len(new_col) >= 100:
				break
		new_array.append(new_col)
		max_len = max(max_len, len(new_col))
	for r in range(clen):
		ext_len = max_len - len(new_array[r])
		if ext_len > 0:
			new_array[r] += [0 for _ in range(ext_len)]
	ret_array = [[0 for _ in range(clen)] for _ in range(max_len)]
	for r in range(len(new_array)):
		for c in range(max_len):
			ret_array[c][r] = new_array[r][c]
	return ret_array

r, c, k = map(int, input().split())
r, c = r-1, c-1
array = []
for _ in range(3):
	array.append(list(map(int, input().split())))
answer = -1
for time in range(101):
	rlen = len(array)
	clen = len(array[0])
	if r in range(rlen) and c in range(clen) and array[r][c] == k:
		answer = time
		break
	if rlen >= clen:
		array = r_cal(array, rlen, clen)
	else:
		array = l_cal(array, rlen, clen)
print(answer)
