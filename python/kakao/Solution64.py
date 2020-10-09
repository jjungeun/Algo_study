from collections import defaultdict, deque

def spring_summer(N, land, tree):
	global answer
	for r in range(N):
		for c in range(N):
			for k in range(len(tree[r][c])):
				if tree[r][c][k] <= land[r][c]:
					land[r][c] -= tree[r][c][k]
					tree[r][c][k] += 1
				else:
					while k < len(tree[r][c]):
						land[r][c] += tree[r][c].pop()//2
						answer -= 1
					break

dr = [-1, -1, -1, 0, 0, 1, 1, 1]
dc = [-1, 0, 1, -1, 1, -1, 0, 1]
def fall_winter(N, A, land, tree):
	global answer
	for r in range(N):
		for c in range(N):
			for k in range(len(tree[r][c])):
				if tree[r][c][k] % 5 == 0:
					for i in range(8):
						nr, nc = r+dr[i], c+dc[i]
						if nr not in range(N) or nc not in range(N):
							continue
						tree[nr][nc].appendleft(1)
						answer += 1
			land[r][c] += A[r][c]

if __name__ == "__main__":
	N, M, K = map(int, input().split(' '))
	land = [[5 for _ in range(N)] for _ in range(N)]
	tree = [[deque() for _ in range(N)] for _ in range(N)]
	A = [list(map(int, input().split(' '))) for _ in range(N)]

	answer = 0
	for _ in range(M):
		x, y, z = map(int, input().split(' '))
		tree[x-1][y-1].append(z)
		answer += 1

	for year in range(K):
		spring_summer(N, land, tree)
		fall_winter(N, A, land, tree)
	print(answer)
