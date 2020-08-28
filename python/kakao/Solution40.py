dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def short_dist(row, col, visited, min_cnt):
	answer = N*N
	if row == N-1 and col == N-1:
		return min_cnt
	visited[row][col] = True
	for i in range(4):
		new_col = col+dx[i]
		new_row = row+dy[i]
		if 0 <= new_col < N and 0 <= new_row < N and route[new_row][new_col] == 1 and not visited[new_row][new_col]:
			answer = min(answer, short_dist(new_row, new_col, visited, min_cnt+1))
	visited[row][col] = False
	return answer

N = int(input())
route = []
for _ in range(N):
	route.append(list(map(int, input().split(' '))))
visited = [[False for _ in range(N)] for _ in range(N)]
ans = short_dist(0, 0, visited, 1)
if ans != N*N:
	print(ans)
