import copy

def turn(key):
	newkey = []
	N = len(key)
	for rid in range(N):
		row = len(key) - rid - 1
		for col in range(N):
			if len(newkey) <= col:
				newkey.append([key[row][col]])
			else:
				newkey[col].append(key[row][col])
	return newkey

def ismatch(key, lock, rdiff, cdiff):
	N = len(key)
	M = len(lock)
	tmp_lock = copy.deepcopy(lock)
	for r in range(N):
		for c in range(N):
			if key[r][c] == 1 and r + rdiff >= 0 and r + rdiff < M and c + cdiff >= 0 and c + cdiff < M:
				tmp_lock[r+rdiff][c+cdiff] += 1
	for r in range(M):
		for c in range(M):
			if tmp_lock[r][c] != 1:
				return False
	return True

def iskey(key, lock, kr, kc):
	M = len(lock)
	for r in range(M):
		for c in range(M):
			if lock[r][c] == 0:
				rdiff = r - kr
				cdiff = c - kc
				if ismatch(key, lock, rdiff, cdiff):
					return True
	return False

def solution(key, lock):
	N = len(key)
	for i in range(0, 4):
		for kr in range(N):
			for kc in range(N):
				if key[kr][kc] == 1 and iskey(key, lock, kr, kc):
					return True
		key = turn(key)
	return False

key = [[0, 0, 0], [1, 0, 0], [0, 1, 1]]
lock = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
solution(key, lock)

# lock
# 1 1 1
# 1 1 0
# 1 0 1


# 1,2
# 1,0
# rdiff = 2
# cdiff = 0

# 0 0 0
# 1 0 0
# 0 1 1

# 0 1 0
# 1 0 0
# 1 0 0

# 1 1 0
# 0 0 1
# 0 0 0

# 0 0 1
# 0 0 1
# 0 1 0

##########33

# 지금
# 1 1 1
# 2 1 0
# 1 1 2

# 90
# 1 2 1
# 2 1 0
# 2 0 1

# 180
# 2 2 1
# 1 1 1
# 1 0 1

# 270
# 1 1 2
# 1 1 1
# 1 1 1

# 조건
# - 0의 개수가 key의 개수보다 크면 false
# -
