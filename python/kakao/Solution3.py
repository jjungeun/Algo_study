def solution(budgets, M):
	answer = 0
	budgets = sorted(budgets, reverse=True)
	budsum = sum(budgets)
	if budsum <= M:
		return budgets[0]
	sub = budsum - M
	idx = 0
	budmax = budgets[0]
	while sub > 0:
		for i in range(idx+1, len(budgets)):
			if i < len(budgets) and budgets[i] == budmax:
				idx += 1
			else:
				break
		budmax -= 1
		sub -= idx+1
	return budmax

print(solution([120, 110, 140, 150], 1485))
