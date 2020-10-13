from collections import defaultdict
import copy

def turn(x,d,k):
	for key in range(1, N+1):
		# x의 배수가 아닐때
		if key % x != 0:
			continue
		for _ in range(k):
			# 시계방향
			if d == 0:
				pos[key] = (pos[key] - 1) % M
			# 반시계방향
			else:
				pos[key] = (pos[key] + 1) % M

def remove(rounds):
	is_same = True
	new_rounds = copy.deepcopy(rounds)
	for key in range(1, N+1):
		for i in range(M):
			remove_flag = False
			idx = (pos[key] + i) % M
			if rounds[key][idx] == 0:
				continue
			# 같은 원판에서 인접한 수
			if rounds[key][(idx+1)%M] == rounds[key][idx]:
				new_rounds[key][(idx+1)%M] = 0
				remove_flag = True
			if rounds[key][(idx-1)%M] == rounds[key][idx]:
				new_rounds[key][(idx-1)%M] = 0
				remove_flag = True
			# 위 원판에서 인접한 수
			if key+1 in range(1, N+1) and rounds[key+1][(pos[key+1]+i)%M] == rounds[key][idx]:
				new_rounds[key+1][(pos[key+1]+i)%M] = 0
				remove_flag = True
			if remove_flag:
				new_rounds[key][idx] = 0
				is_same = False
	# 지울게 없는 경우
	if is_same:
		avg = 0
		cnt = 0
		for key in range(1, N+1):
			for num in new_rounds[key]:
				if num != 0:
					avg += num
					cnt += 1
		if cnt != 0:
			avg = avg / cnt
			for key in range(1, N+1):
				for idx in range(M):
					if new_rounds[key][idx] == 0:
						continue
					elif new_rounds[key][idx] > avg:
						new_rounds[key][idx] -= 1
					elif new_rounds[key][idx] < avg:
						new_rounds[key][idx] += 1
	return new_rounds


N, M, T = map(int, input().split())
rounds = defaultdict(list)
pos = [0 for _ in range(N+1)]
pos[0] = -1
for i in range(N):
	rounds[i+1] = list(map(int, input().split()))

for _ in range(T):
	x, d, k = map(int, input().split())
	turn(x,d,k)
	rounds = remove(rounds)

answer = 0
for key in range(1, N+1):
	answer += sum(rounds[key])
print(answer)
