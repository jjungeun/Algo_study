def solution(N, number):
	answer = 0
	dp = [0, {N}]
	for i in range(2, 9):
		case_set = {int(str(N) * i)}
		for i_half in range(1, i//2+1):
			for x in dp[i_half]:
				for y in dp[i-i_half]:
					case_set.add(x+y)
					case_set.add(x-y)
					case_set.add(y-x)
					case_set.add(x*y)
					if y != 0:
						case_set.add(x//y)
					if x != 0:
						case_set.add(y//x)
		if number in case_set:
			return i
		dp.append(case_set)
	return -1



	return answer
