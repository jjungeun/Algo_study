def solution(m, n, puddles):
	dp = [[0 for _ in range(m+1)] for _ in range(n+1)]
	dp[1][1] = 1
	for row in range(1, n+1):
		for col in range(1, m+1):
			if [col, row] in puddles:
				dp[row][col] = 0
				continue
			dp[row][col] += dp[row-1][col] + dp[row][col-1]
	return dp[-1][-1] % 1000000007

print(solution(4, 3, [[1,2], [2,2]]))
