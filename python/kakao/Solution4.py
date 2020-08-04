import copy
def init_lock(lock, M, N):
	new_lock = [[0 for _ in range(N+2*M-2)] for _ in range(N+2*M-2)]
	for row_idx in range(N):
		for col_idx in range(N):
			new_lock[row_idx+M-1][col_idx+M-1] = lock[row_idx][col_idx]
	return new_lock

def turn_key(key, M):
	new_key = []
	for col_idx in range(M):
		new_row = []
		for row_idx in range(M):
			new_row.append(key[M-row_idx-1][col_idx])
		new_key.append(new_row)
	return new_key

def is_key(result, M, N):
	for row_idx in range(M-1, M+N-1):
		for col_idx in range(M-1, M+N-1):
			if result[row_idx][col_idx] != 1:
				return False
	return True

def test_all_case(key, lock, M, N):
	for row_idx in range(M+N-1):
		for col_idx in range(M+N-1):
			result = copy.deepcopy(lock)
			for r in range(M):
				for c in range(M):
					result[row_idx + r][col_idx + c] += key[r][c]
			if is_key(result, M, N):
				return True
	return False

def solution(key, lock):
	M = len(key)
	N = len(lock)
	lock = init_lock(lock, M, N)
	for _ in range(4):
		if test_all_case(key, lock, M, N):
			return True
		key = turn_key(key, M)
	return False
