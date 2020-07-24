from itertools import permutations

def perm(n, weak, idx):
	newArr = []
	for i in range(idx, idx + len(weak)):
		if i < len(weak):
			newArr.append(weak[i])
		else:
			newArr.append(weak[i%len(weak)] + n)
	return newArr

def isOkay(case, newArr):
	caseIdx = 0
	arrIdx = 0
	while True:
		if caseIdx == len(case):
			return False
		if arrIdx == len(newArr) - 1:
			break
		for i in range(arrIdx, len(newArr) - 1):
			distance = newArr[i+1] - newArr[i]
			distance = distance if distance > 0 else abs(distance)
			if distance <= case[caseIdx]:
				case[caseIdx] -= distance
				arrIdx += 1
			else:
				arrIdx += 1
				caseIdx += 1
				break
	return True

def solution(n, weak, dist):
	answer = len(dist) + 1
	casedist = []
	for i in range(len(dist)):
		casedist += list(permutations(dist, i +1))
	for i, w in enumerate(weak):
		newArr = perm(n, weak, i)
		for case in casedist:
			if isOkay(list(case), newArr) and len(case) < answer:
				answer = len(case)
	return answer if answer <= len(dist) else -1

# 실패한 풀이
def bad_solution(n, weak, dist):
	answer = len(dist) + 1
	dist = sorted(dist, reverse=True)
	casedist = []
	for i in range(len(dist)):
		casedist.append(dist[:i + 1])
	for i, w in enumerate(weak):
		newArr = perm(n, weak, i)
		for case in casedist:
			if isOkay(case[:], newArr) and len(case) < answer:
				answer = len(case)
		newArr = list(reversed(newArr))
		for case in casedist:
			if isOkay(case[:], newArr) and len(case) < answer:
				answer = len(case)
	return answer if answer <= len(dist) else -1

n = 50
weak = 	[1,5,10,12,22,25]
# weak = [1, 3, 4, 9, 10]
dist = [4,3,2,1]
# dist = [1,2,3,4]
# dist = [3,5,7]
print(solution(n, weak, dist))
