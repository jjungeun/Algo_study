import sys

def same_area(start, end):
	sr, sc = start
	er, ec = end
	prev = bitmap[sr][sc]
	for r in range(sr, er):
		for c in range(sc, ec):
			if bitmap[r][c] != prev:
				return False
	return True

d = [[(0, 0),(-1, -1)], [(0, 1),(-1, 0)], [(1, 0), (0, -1)], [(1, 1), (0,0)]]
def divide(start, end):
	answer = []
	if same_area(start, end):
		r, c = start
		return bitmap[r][c]
	sr, sc = start
	er, ec = end
	n = (er - sr) // 2		#블록 크기
	for i in range(4):
		ds = d[i][0]
		de = d[i][1]
		ns = (sr+ds[0]*n, sc+ds[1]*n)
		ne = (er+de[0]*n, ec+de[1]*n)
		if same_area(ns, ne):
			r, c = ns
			answer.append(bitmap[r][c])
		else:
			answer.append(list(divide(ns, ne)))
	return answer

def print_answer(answer):
	ans_str = ''
	if type(answer) == int:
		return answer
	for i in range(len(answer)):
		if type(answer[i]) == int:
			ans_str += str(answer[i])
		else:
			ans_str += print_answer(answer[i])
	return '(' + ans_str + ')'

if __name__ == '__main__':
	N = int(sys.stdin.readline())
	bitmap = []
	for _ in range(N):
		row = sys.stdin.readline().strip('\n')
		bitmap.append(list(map(int, row.strip())))
	start, end = (0, 0), (N, N)
	answer = divide(start, end)
	#[[1, 1, 0, [0, 1, 0, 1]], [0, 0, 1, 0], 1, [0, 0, 0, 1]]
	print(print_answer(answer))
