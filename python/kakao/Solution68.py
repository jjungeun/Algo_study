import copy
# 블록 움직이기
def move(block, col, num, is_horizon):
	prev_r = -1
	for row in range(6):
		if not is_horizon and block[row][col] > 0:
			break
		elif is_horizon and (block[row][col] > 0 or block[row][col+1] > 0):
			break
		prev_r = row
	if not is_horizon:
		block[prev_r][col] = num
	else:
		block[prev_r][col] = num
		block[prev_r][col+1] = num

def new_block(block, b, num, is_reverse):
	t, x, y = b
	if t == 1:
		if is_reverse:
			move(block, 3-x, num, False)
		else:
			move(block, y, num, False)
	elif t == 2:
		if is_reverse:
			move(block, 3-x, num, False)
			move(block, 3-x, num, False)
		else:
			move(block, y, num, True)
	else:
		if is_reverse:
			move(block, 3-x-1, num, True)
		else:
			move(block, y, num, False)
			move(block, y, num, False)

# 행이나 열이 가득찬 경우 처리 (없을때까지) -> 점수 획득
def remove_full(block):
	cnt = 0
	new_block = []
	for row in range(6):
		if 0 not in block[row]:
			continue
		new_block.append(block[row])
		cnt += 1
	new_block = [[0 for _ in range(4)] for _ in range(6-cnt)] + new_block
	return 6 - cnt, new_block

# 연한 칸에 블록이 있는 경우 처리
def remove(block):
	cnt = 0
	for row in range(2):
		for col in range(4):
			if block[row][col] > 0:
				cnt += 1
				break
	block = [[0 for _ in range(4)] for _ in range(cnt)] + block[:6-cnt]
	return block

# 내릴거 내리기
def go_down(block):
	is_change = False
	for row in range(5, 1, -1):
		for col in range(4):
			if block[row][col] == 0:
				for up_row in range(row-1, 1, -1):
					if block[up_row][col] != 0:
						num = block[up_row][col]
						# 세로인경우
						if block[up_row-1][col] == num:
							block[up_row][col] = 0
							block[up_row-1][col] = 0
							block[row][col] = num
							block[row-1][col] = num
							is_change = True
						elif up_row+1 in range(6) and block[up_row+1][col] == num:
							break
						# 가로인경우
						elif col+1 in range(4) and block[up_row][col+1] == num:
							can_down = True
							for tmp_r in range(row, up_row, -1):
								if block[tmp_r][col+1] != 0:
									can_down = False
									break
							if can_down:
								block[up_row][col] = 0
								block[up_row][col+1] = 0
								block[row][col] = num
								block[row][col+1] = num
								is_change = True
						elif col-1 in range(4) and block[up_row][col-1] == num:
							break
						# 한개인경우
						else:
							block[up_row][col] = 0
							block[row][col] = num
							is_change = True
						break
	return is_change, block

N = int(input())
blocks = []
for _ in range(N):
	blocks.append(list(map(int, input().split())))
green = [[0 for _ in range(4)] for _ in range(6)]
blue = [[0 for _ in range(4)] for _ in range(6)]
point, cnt = 0, 0
num = 1
for b in blocks:
	new_block(green, b, num, False)
	new_block(blue, b, num, True)

	g_point, green = remove_full(green)
	b_point, blue = remove_full(blue)
	point += g_point + b_point
	green = remove(green)
	blue = remove(blue)

	while True:
		green_change, green = go_down(green)
		blue_change, blue = go_down(blue)
		g_point, green = remove_full(green)
		b_point, blue = remove_full(blue)
		point += g_point + b_point
		if not green_change and not blue_change:
			break

	# print(b)
	# print('green', green)
	# print()
	# print('blue', blue)
	# print()
	# print()
	num += 1

for row in range(2,6):
	for col in range(4):
		if green[row][col] != 0:
			cnt += 1
		if blue[row][col] != 0:
			cnt += 1
print(point)
print(cnt)
