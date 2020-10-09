def same_area(bitmap, start, end):
	sr, sc = start
	er, ec = end
	prev = bitmap[sr][sc]
	for r in range(sr, er):
		for c in range(sc, ec):
			if bitmap[r][c] != prev:
				return False
	return True

d = [[(0, 0),(-1, -1)], [(0, 1),(-1, 0)], [(1, 0), (0, -1)], [(1, 1), (0,0)]]
def divide(bitmap, start, end):
	answer = []
	if same_area(bitmap, start, end):
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
		if same_area(bitmap, ns, ne):
			r, c = ns
			answer.append(bitmap[r][c])
		else:
			answer.append(list(divide(bitmap, ns, ne)))
	return answer

def cnt(zip_arr):
	answer = [0, 0]
	if type(zip_arr) is int:
		if zip_arr == 0:
			return [1, 0]
		else:
			return [0, 1]
	for arr in zip_arr:
		if type(arr) is int:
			if arr == 0:
				answer[0] += 1
			else:
				answer[1] += 1
		else:
			new_ans = cnt(arr)
			answer[0] += new_ans[0]
			answer[1] += new_ans[1]
	return answer

def solution(arr):
	answer = [0,0]
	N = len(arr)
	start, end = (0, 0), (N, N)
	zip_arr = divide(arr, start, end)
	return cnt(zip_arr)

arr = [[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]
arr = [[1]]
print(solution(arr))
