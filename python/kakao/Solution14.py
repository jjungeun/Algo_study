def solution(stones, k):
	answer = 200000000
	idx = -1
	if k == 1:
		return min(stones)
	while idx + k <= len(stones):
		if idx + k < len(stones):
			next_stone = stones[idx+1:idx+k+1]
			next_max = max(next_stone)
			if next_max < answer:
				answer = next_max
			idx += next_stone.index(next_max) + 1
		else:
			break
	return answer

stones = [2, 4, 5, 3, 2, 1, 4, 2, 5, 1]
# stones = [2, 44, 5]

k = 3
print(solution(stones, k))

# def go_possible(check, k):
# 	never_go = 0
# 	for c in check:
# 		if c == 0:
# 			never_go += 1
# 			if never_go >= k:
# 				return False
# 		else:
# 			never_go = 0
# 	return True

# def solution(stones, k):
# 	answer = 1
# 	stone_case = {}
# 	for i, v in enumerate(stones):
# 		if v in stone_case.keys():
# 			stone_case[v] += [i]
# 		else:
# 			stone_case[v] = [i]
# 	check = [0 for i in range(len(stones))]
# 	for case in sorted(stone_case.keys(), reverse=True):
# 		for idx in stone_case[case]:
# 			check[idx] = 1
# 		if go_possible(check, k):
# 			answer = case
# 			break
# 	return answer
