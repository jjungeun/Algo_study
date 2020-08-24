def get_cases():
	answer = 0
	i, j, result = 0, 0, nums[0]
	while i < len(nums):
		if result == M:
			answer += 1
		if result >= M or j == len(nums) - 1:
			result -= nums[i]
			i += 1
		elif result < M:
			j += 1
			result += nums[j]
	return answer

if __name__=='__main__':
	N, M = map(int, input().split())
	nums = list(map(int,input().split()))
	print(get_cases())
