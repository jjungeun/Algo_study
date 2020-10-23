import sys
sys.stdin = open("input.txt", "r")

K, N = map(int, input().split())
lines = []
for _ in range(K):
	lines.append(int(input()))
lines = sorted(lines)
lidx = 1
ridx = lines[-1]
answer = lidx
while lidx <= ridx:
	mid = (lidx+ridx) // 2
	tmp = 0
	for l in lines:
		tmp += l // mid
	if tmp >= N:
		answer = mid if mid >= answer else answer
		lidx = mid+1
	else:
		ridx = mid-1
print(answer)
