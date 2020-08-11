def dfs(pre_idx, pay, max_pay):
	next_idx = pre_idx + works[pre_idx][0] if pre_idx >= 0 else 0
	for idx in range(next_idx, N):
		if idx + works[idx][0] > N:
			continue
		max_pay =dfs(idx, pay + works[idx][1], max_pay)
	return max(pay, max_pay)

N = int(input())
works = []
for _ in range(N):
	works.append(list(map(int, input().split(' '))))
print(dfs(-1, 0, 0))
