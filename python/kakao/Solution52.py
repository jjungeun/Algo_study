def solution(triangle):
	answer = 0
	N = len(triangle)
	dp = [[0 for _ in range(N)] for _ in range(N)]
	dp[0][0] = triangle[0][0]
	for r in range(1, N):
		for c in range(r+1):
			# 맨 왼쪽
			if r - c == r:
				dp[r][c] = dp[r-1][c] + triangle[r][c]
			# 맨 오른쪽
			elif r - c == 0:
				dp[r][c] = dp[r-1][c-1] + triangle[r][c]
			# 가운데
			else:
				max_value = max([dp[r-1][i] for i in range(c-1, c+1)])
				dp[r][c] = max_value + triangle[r][c]
	return max(dp[-1])

triangle = [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]
print(solution(triangle))
