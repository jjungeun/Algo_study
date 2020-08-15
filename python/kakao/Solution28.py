def dfs(pre_row, pre_col, num, sum_square):
	max_sum = sum_square
	if num == 4:
		return sum_square
	if pre_row - 1 > 0 and visited[pre_row-1][pre_col] == 0:
		squre_num = paper[pre_row-1][pre_col]
		visited[pre_row-1][pre_col] = 1
		max_sum = max(max_sum, dfs(pre_row-1, pre_col, num+1, sum_square+squre_num))
		visited[pre_row-1][pre_col] = 0

	if pre_col + 1 < M and visited[pre_row][pre_col+1] == 0:
		squre_num = paper[pre_row][pre_col+1]
		visited[pre_row][pre_col+1] = 1
		max_sum = max(max_sum, dfs(pre_row, pre_col+1, num+1, sum_square+squre_num))
		visited[pre_row][pre_col+1] = 0

	if pre_row + 1 < N and visited[pre_row+1][pre_col] == 0:
		squre_num = paper[pre_row+1][pre_col]
		visited[pre_row+1][pre_col] = 1
		max_sum = max(max_sum, dfs(pre_row+1, pre_col, num+1, sum_square+squre_num))
		visited[pre_row+1][pre_col] = 0

	if pre_col - 1 > 0 and visited[pre_row][pre_col-1] == 0:
		squre_num = paper[pre_row][pre_col-1]
		visited[pre_row][pre_col-1] = 1
		max_sum = max(max_sum, dfs(pre_row, pre_col-1, num+1, sum_square+squre_num))
		visited[pre_row][pre_col-1] = 0
	return max_sum

def check(pre_row, pre_col, arr):
	sum = 0
	for square in arr:
		if pre_row + square[0] in range(0, N) and pre_col + square[1] in range(0, M):
			sum += paper[pre_row+square[0]][pre_col+square[1]]
		else:
			return 0
	return sum

def special_case(pre_row, pre_col, sum_square):
	up = [[0,1],[-1,1],[0,2]]
	down = [[0,1],[1,1],[0,2]]
	right = [[1,0],[1,1],[2,0]]
	left = [[1,0],[1,-1],[2,0]]
	max_square = sum_square
	max_square = max(max_square, sum_square + check(pre_row, pre_col, up))
	max_square = max(max_square, sum_square + check(pre_row, pre_col, down))
	max_square = max(max_square, sum_square + check(pre_row, pre_col, right))
	max_square = max(max_square, sum_square + check(pre_row, pre_col, left))
	return max_square

def find_max():
	answer = 0
	for row in range(N):
		for col in range(M):
			visited[row][col] = 1
			answer = max(answer, dfs(row, col, 1, paper[row][col]))
			answer = max(answer, special_case(row, col, paper[row][col]))
			visited[row][col] = 0
	return answer


N, M = list(map(int, input().split(' ')))
paper = []
for _ in range(N):
	paper.append(list(map(int, input().split(' '))))
visited = [[0 for _ in range(M)] for _ in range(N)]
print(find_max())
