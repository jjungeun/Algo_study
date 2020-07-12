def toBase(base, num):
	if num < 10:
		return str(num)
	else:
		return chr(ord('A') + num - 10)

def chBase(base, num):
	if int(num / base) == 0:
		return toBase(base, int(num))
	return chBase(base, num / base) + toBase(base, int(num % base))

def solution(n, t, m, p):
	answer = ''
	num = 0
	count = 0
	while True:
		newNum = chBase(n, num)
		for i, v in enumerate(newNum):
			if count % m == p - 1:
				answer += v
				if len(answer) == t:
					return answer
			count += 1
		num += 1

print(solution(2,4,2,1))
# print(chBase(16,16))
