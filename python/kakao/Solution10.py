def init(expression):
	idx = 0
	num = []
	operator = []
	for i, exp in enumerate(expression):
		if exp.isdigit() == False:
			num.append(int(expression[idx : i]))
			operator += exp
			idx = i + 1
	num.append(int(expression[idx : len(expression)]))
	return num, operator

def doCal(num1, num2, operator):
	if operator == "*":
		return num1 * num2
	elif operator == "+":
		return num1 + num2
	else:
		return num1 - num2

def cal(num, operator, prior):
	for p in prior:
		while p in operator:
			idx = operator.index(p)
			num[idx] = doCal(num[idx], num[idx + 1], p)
			num.pop(idx + 1)
			operator.pop(idx)
	return num[0]

def solution(expression):
	answer = 0
	priors = ["*+-","*-+","+*-","+-*","-*+","-+*"]
	num, operator = init(expression)
	for prior in priors:
		ret = cal(num[:], operator[:], prior)
		if abs(ret) > answer:
			answer = abs(ret)
	return answer

print(solution("50*6-3*2"))
