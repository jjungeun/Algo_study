import copy
center_next = {
	10: 13, 13: 16, 16: 19, 19:25, 25: 30,
	30: 35, 35: 40, 40: 42,
	20: 22, 22: 24, 24: 25,
	28: 27, 27: 26, 26: 25, 29: 28
}

def move(turn, new_pos, new_center, i):
	next = -1
	value = num[turn]
	if new_center[i] == True:
		pos = new_pos[i]
		for _ in range(value):
			next = center_next[pos]
			if next == 42:
				break
			pos = next
		if next != 42 and next in new_pos:
			same_idx = new_pos.index(next)
			if new_center[same_idx] == True or next == 40:
				next = -1
	else:
		new_value = new_pos[i] + 2 * value
		if new_value > 40:
			next = 42
		elif new_value == 30 and 29 not in new_pos:
			next = 29
		elif new_value not in new_pos:
			next = new_value
		elif new_value not in [10, 20, 30, 40]:
			same_idx = new_pos.index(new_value)
			if new_center[same_idx] == True:
				next = new_value
	return next

def dfs(turn, pos, center, answer):
	max_answer = answer
	if turn == 10:
		return answer
	new_pos = copy.deepcopy(pos)
	new_center = copy.deepcopy(center)
	# 움직일 말 고르기
	for i in range(4):
		tmp_value = answer
		# 이미 도착한말
		if new_pos[i] == 42:
			continue
		next = move(turn, new_pos, new_center, i)
		# 이동을 마치는 칸에 다른 말이 있는 경우
		if next == -1:
			continue
		prev_center = new_center[i]
		if next == 10 or next == 20 or next == 29:
			new_center[i] = True
		if next != 42:
			tmp_value += next if next != 29 else 30
		prev = new_pos[i]
		new_pos[i] = next
		max_answer = max(max_answer, dfs(turn+1, new_pos, new_center, tmp_value))
		new_pos[i] = prev
		new_center[i] = prev_center
	return max_answer

pos = [0, 0, 0, 0]
center = [False, False, False, False]
num = list(map(int, input().split()))
print(dfs(0, pos, center, 0))

