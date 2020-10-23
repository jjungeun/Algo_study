def solution(n, times):
	answer = 0
	times = sorted(times)
	lidx = 1
	ridx = n * times[-1]
	answer = ridx
	while lidx <= ridx:
		mid = (lidx + ridx) // 2
		sum = 0
		for t in times:
			sum += mid // t
		if sum >= n:
			answer = mid if answer > mid else answer
			ridx = mid-1
		else:
			lidx = mid+1
	return answer

n = 6
times = [7,10]
print(solution(n, times))
