def solution(n, money):
	money = sorted(money)
	dp = [[0 for _ in range(n+1)] for _ in range(len(money))]

	dp[0][0] = 1
	# 동전의 최솟값이 1이 아닌 경우대비
	for i in range(money[0], n+1, money[0]):
		dp[0][i] = 1

	for r in range(1, len(money)):
		for c in range(n+1):
			if c >= money[r]:
				dp[r][c] = (dp[r-1][c] + dp[r][c-money[r]]) % 1000000007
			else:
				dp[r][c] = dp[r-1][c]
	return dp[-1][-1]

n = 5
money = [1,2,5]
print(solution(n, money))
