def to_lower(load, idx, runway):
	if idx + L > N:
		return False
	for n in range(L):
		if load[idx] != load[idx + n] or runway[idx + n] == 1:
			return False
		runway[idx+n] = 1
	return True

def to_higher(load, idx, runway):
	if idx - L < 0:
		return False
	for n in range(L):
		if load[idx - 1] != load[idx - n - 1] or runway[idx - n - 1] == 1:
			return False
		runway[idx - n - 1] = 1
	return True

def check_load(load):
	same_dist = 0
	pre = load[0]
	idx = 0
	runway = [0 for _ in range(N)]

	while idx < N:
		# 전이랑 같은경우
		if pre == load[idx]:
			same_dist += 1
			idx += 1
			continue
		# 차이가 1이상 나는 경우
		if max(pre, load[idx]) - min(pre, load[idx]) > 1:
			return 0

		if pre > load[idx]:

			if to_lower(load, idx, runway):
				pre = load[idx]
				idx += L
			else:
				return 0
		elif pre < load[idx]:
			if to_higher(load, idx, runway):
				pre = load[idx]
				idx += 1
			else:
				return 0
		same_dist = 1
	return 1

def passby_load(loads):
	answer = 0
	for idx in range(N):
		answer += check_load(loads[idx])
		col_load = []
		for r in range(N):
			col_load.append(loads[r][idx])
		answer += check_load(col_load)
	return answer

if __name__ == "__main__":
	N, L = map(int, input().split(' '))
	loads = []
	for r in range(N):
		loads.append(list(map(int, input().split(' '))))
	print(passby_load(loads))
