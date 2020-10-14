import sys
sys.stdin = open("input.txt", "r")
import copy
from collections import deque

def top(bricks, c):
	for r in range(H):
		if bricks[r][c] != 0:
			return r
	return -1

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]
def pop(bricks, c):
	cnt = 0
	new_bricks = copy.deepcopy(bricks)
	pop_q = deque()
	r = top(bricks, c)
	if r in range(H):
		pop_q.append((r, c, bricks[r][c]))
	ans = []
	while pop_q:
		r, c, s = pop_q.popleft()
		for i in range(1, s):
			for j in range(4):
				nr, nc = r+dr[j]*i, c+dc[j]*i
				if nr not in range(H) or nc not in range(W) or new_bricks[nr][nc] == 0:
					continue
				if new_bricks[nr][nc] > 1:
					pop_q.append((nr, nc, new_bricks[nr][nc]))
				new_bricks[nr][nc] = 0
		new_bricks[r][c] = 0
	return new_bricks

def down(bricks):
	for c in range(W):
		new_col = []
		top_idx = H-1
		for r in range(H-1, -1, -1):
			if bricks[r][c] != 0:
				bricks[top_idx][c] = bricks[r][c]
				top_idx -= 1
		if top_idx == -1:
			continue
		for r in range(top_idx, -1, -1):
			bricks[r][c] = 0

def get_bricks(bricks):
	cnt = 0
	for r in range(H):
		for c in range(W):
			if bricks[r][c] != 0:
				cnt += 1
	return cnt

def dfs(bricks, turn):
	if turn == N:
		return get_bricks(bricks)
	min_answer = W*H
	new_bricks = copy.deepcopy(bricks)
	for c in range(W):
		pop_bricks = pop(new_bricks, c)
		down(pop_bricks)
		min_answer = min(min_answer, dfs(pop_bricks, turn+1))
	return min_answer

T = int(input())
for test_case in range(1, T + 1):
	N, W, H = map(int, input().split())
	bricks = []
	for _ in range(H):
		bricks.append(list(map(int, input().split())))
	bricks_cnt = get_bricks(bricks)
	answer = dfs(copy.deepcopy(bricks), 0)
	print("#%d %d" % (test_case, answer))
