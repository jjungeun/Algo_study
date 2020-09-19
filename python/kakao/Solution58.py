N = int(input())
tester = list(map(int, input().split(' ')))
B, C = map(int, input().split(' '))

answer = 0
for t in tester:
	sum_t = t - B
	answer += 1
	if sum_t > 0:
		answer += sum_t // C
		answer += 1 if sum_t % C != 0 else 0
print(answer)
