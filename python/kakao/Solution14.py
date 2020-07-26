def is_possible(stones, value, k):
	for i in range(len(stones)):
		stones[i] = 1 if stones[i] > value else 0
	zeros = 0
	for s in stones:
		if s == 0:
			zeros += 1
			if zeros == k:
				return False
		else:
			zeros = 0
	return True

def solution(stones, k):
	min_value = min(stones)
	max_value = max(stones)
	while min_value <= max_value:
		value = int((max_value + min_value) / 2)
		if is_possible(stones[:], value, k):
			min_value = value + 1
		else:
			max_value = value - 1
	return min_value

# stones = [2, 4, 5, 3, 2, 1, 4, 2, 5, 1]
stones = [2, 44, 5]

k = 3
print(solution(stones, k))

# def solution(stones, k):
# 	answer = 200000000
# 	idx = -1
# 	if k == 1:
# 		return min(stones)
# 	while idx + k <= len(stones):
# 		if idx + k < len(stones):
# 			next_stone = stones[idx+1:idx+k+1]
# 			next_max = max(next_stone)
# 			if next_max < answer:
# 				answer = next_max
# 			idx += next_stone.index(next_max) + 1
# 		else:
# 			break
# 	return answer
