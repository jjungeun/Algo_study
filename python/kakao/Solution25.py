def get_right(point, gear_idx):
	right_idx = (point[gear_idx] + 2) % 8
	return gear[gear_idx][right_idx]

def get_left(point, gear_idx):
	left_idx = (point[gear_idx] + 6) % 8
	return gear[gear_idx][left_idx]

def turn(point, N, D):
	# 톱니바퀴 한개 움직이기
	left = get_left(point, N - 1)
	right = get_right(point, N - 1)
	point[N-1] = (point[N-1] + D + 8) % 8

	# 왼쪽에 있는 톱니바퀴들 움직이기
	turn_direct = D * -1
	for i in range(N-2, -1, -1):
		if get_right(point, i) == left:
			break
		left = get_left(point, i)
		point[i] = (point[i] + turn_direct + 8) % 8
		turn_direct *= -1

	# 오른쪽에 있는 톱니바퀴들 움직이기
	turn_direct = D * -1
	for i in range(N, 4):
		if get_left(point, i) == right:
			break
		right = get_right(point, i)
		point[i] = (point[i] + turn_direct + 8) % 8
		turn_direct *= -1

import math
if __name__ == "__main__":
	gear = []
	for _ in range(4):
		gear.append(input().split('\n')[0])
	K = int(input())
	point = [0, 0, 0, 0]
	for _ in range(K):
		N, D = map(int, input().split(' '))
		# 시계방향일때 -1, 반시계일때 1로
		turn(point, N, D * -1)
	answer = 0
	for idx in range(4):
		gear_idx = point[idx]
		answer += int(gear[idx][gear_idx]) * math.pow(2, idx)
	print(int(answer))
