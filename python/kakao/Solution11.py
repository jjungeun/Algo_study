def canBuild(answer, row, col, target):
	if target == 0:
		if col == 0 or [row, col - 1, 0] in answer or [row - 1, col, 1] in answer or [row, col, 1] in answer:
			return True
	else:
		if [row, col - 1, 0] in answer or [row + 1, col - 1, 0] in answer or ([row - 1, col, 1] in answer and [row + 1, col, 1] in answer):
			return True
	return False

def canDestroy(answer, row, col, target):
	if [row, col, target] not in answer:
		return False
	idx = answer.index([row, col, target])
	newans = answer[:idx] + answer[idx + 1:]
	for ans in newans:
		if not canBuild(newans, ans[0], ans[1], ans[2]):
			return False
	return True

def solution(n, build_frame):
	answer = []
	for frame in build_frame:
		if frame[3] == 1 and canBuild(answer, frame[0], frame[1], frame[2]):
			answer.append([frame[0],frame[1],frame[2]])
		elif frame[3] == 0 and canDestroy(answer, frame[0], frame[1], frame[2]):
			answer.pop(answer.index([frame[0], frame[1], frame[2]]))
	answer = sorted(answer, key = lambda k: (k[0], k[1], k[2]))
	return answer

frame = [[0,0,0,1],[2,0,0,1],[4,0,0,1],[0,1,1,1],[1,1,1,1],[2,1,1,1],[3,1,1,1],[2,0,0,0],[1,1,1,0],[2,2,0,1]]
print(solution(5, frame))
