def is_valid():
	for i in range(1, N+1):
		col = i
		for row in range(1, H+1):
			if line_pos[row][col] == 1:
				col += 1
			elif line_pos[row][col-1] == 1:
				col -= 1
		if col != i:
			return False
	return True

def can_modify(depth, min_depth, start_r, start_c):
	if depth > 3:
		return depth
	elif is_valid():
		return min(min_depth, depth)
	for r in range(start_r, H+1):
		if r == start_r:
			c_range = range(start_c+1, N+1)
		else:
			c_range = range(1, N+1)
		for c in c_range:
			if line_pos[r][c] == 0 and line_pos[r][c-1] == 0 and line_pos[r][c+1] == 0:
				line_pos[r][c] = 1
				min_depth = min(min_depth, can_modify(depth+1, min_depth, r, c))
				line_pos[r][c] = 0
	return min_depth

N, M, H = map(int, input().split(' '))
lines = []
line_pos = [[0 for _ in range(N+2)] for _ in range(H+2)]
for _ in range(M):
	r, c = map(int, input().split(' '))
	lines.append((r, c))
	line_pos[r][c] = 1
answer = can_modify(0, 4, 1, 0)
print(answer if answer < 4 else -1)
