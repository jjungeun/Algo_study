import sys
sys.stdin = open("input.txt", "r")

# ****
def first():
	answer = 0
	for r in range(N):
		for c in range(M):
			if c + 3 in range(M):
				answer = max(answer, sum(paper[r][c:c+4]))
			if r + 3 in range(N):
				tmp = 0
				for tr in range(r, r+4):
					tmp += paper[tr][c]
				answer = max(answer, tmp)
	return answer

# **
# **
def second():
	answer = 0
	dr = [0, 0, 1, 1]
	dc = [0, 1, 0, 1]
	for r in range(N-1):
		for c in range(M-1):
			tmp = 0
			for i in range(4):
				nr, nc = r+dr[i], c+dc[i]
				tmp += paper[nr][nc]
			answer = max(answer, tmp)
	return answer

# **
# **
# **
def third():
	answer = 0
	dr = [0, 0, 1, 1, 2, 2]
	dc = [0, 1, 0, 1, 0, 1]
	for r in range(N-2):
		for c in range(M-1):
			tmp = 0
			info = {}
			for i in range(6):
				nr, nc = r+dr[i], c+dc[i]
				info[(nr, nc)] = paper[nr][nc]
			info = sorted(info.items(), key=lambda k: k[1])
			pop_r, pop_c = info[0][0]
			i = 1
			while i < 6:
				tr, tc = info[i][0]
				# 같은 행 아니고 대각선아닌경우
				if tr != pop_r and (abs(tr-pop_r) != 1 or abs(tc-pop_c) != 1):
					break
				tmp += paper[tr][tc]
				i += 1
			for v in info[i+1:]:
				tr, tc = v[0]
				tmp += paper[tr][tc]
			answer = max(answer, tmp)
	return answer

# ***
# ***
def fourth():
	answer = 0
	dr = [0, 0, 0, 1, 1, 1]
	dc = [0, 1, 2, 0, 1, 2]
	for r in range(N-1):
		for c in range(M-2):
			tmp = 0
			info = {}
			for i in range(6):
				nr, nc = r+dr[i], c+dc[i]
				info[(nr, nc)] = paper[nr][nc]
			info = sorted(info.items(), key=lambda k: k[1])
			pop_r, pop_c = info[0][0]
			i = 1
			while i < 6:
				tr, tc = info[i][0]
				# 같은 행 아니고 대각선아닌경우
				if tc != pop_c and (abs(tr-pop_r) != 1 or abs(tc-pop_c) != 1):
					break
				tmp += paper[tr][tc]
				i += 1
			for v in info[i+1:]:
				tr, tc = v[0]
				tmp += paper[tr][tc]
			answer = max(answer, tmp)
	return answer

N, M = map(int, input().split())
paper = []
for _ in range(N):
	paper.append(list(map(int, input().split())))
answer = 0
answer = max(answer, first())
answer = max(answer, second())
answer = max(answer, third())
answer = max(answer, fourth())
print(answer)
