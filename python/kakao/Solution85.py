N = int(input())
budget = list(map(int, input().split()))
sum_budget = int(input())

budget = sorted(budget)
lidx = 0
ridx = budget[-1]
answer = lidx
while lidx <= ridx:
	mid = (lidx+ridx) // 2
	tmp = 0
	for b in budget:
		tmp += mid if b >= mid else b
	if tmp > sum_budget:
		ridx = mid-1
	else:
		answer = mid if mid >= answer else answer
		lidx = mid+1
print(answer)
