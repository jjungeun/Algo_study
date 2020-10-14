from collections import defaultdict
import copy
import math

def another_area(area, x, y, d1, d2, cnt):
	d = [[(0, x+d1-1),(0, y)],[(0, x+d2),(y, N)],
	[(x+d1-1,N),(0,y-d1+d2-1)],[(x+d2, N),(y-d1+d2-1, N)]]
	for i in range(4):
		area_num = i+1
		(sr, er), (sc, ec) = d[i]
		for r in range(sr, er):
			for c in range(sc, ec):
				if area[r][c] == 0:
					area[r][c] = area_num
					cnt[area_num] += people[r][c]

def divide_area(area, x, y, d1, d2):
	cnt = defaultdict(int)
	ur, uc = x-1, y-1
	dr, dc = x+d2-1, y+d2-1
	for _ in range(d1+1):
		area[ur][uc] = 5
		ur += 1
		uc -= 1
		area[dr][dc] = 5
		dr += 1
		dc -= 1
	ur, uc = x-1, y-1
	dr, dc = x+d1-1, y-d1-1
	for _ in range(d2+1):
		area[ur][uc] = 5
		ur += 1
		uc += 1
		area[dr][dc] = 5
		dr += 1
		dc += 1
	cnt[5] += people[x-1][y-1]
	cnt[5] += people[x+d1+d2-1][y+d2-d1-1]
	for r in range(x,x+d1+d2-1):
		is_area = False
		for c in range(N):
			if area[r][c] == 5 and is_area:
				cnt[5] += people[r][c]
				break
			elif area[r][c] == 5:
				cnt[5] += people[r][c]
				is_area = True
			elif is_area:
				area[r][c] = 5
				cnt[5] += people[r][c]
	another_area(area, x, y, d1, d2, cnt)
	return max(cnt.values()) - min(cnt.values())
	# 한 선거구는 최소 한개의 구역을 포함


N = int(input())
people = []
for _ in range(N):
	people.append(list(map(int, input().split())))
area = [[0 for _ in range(N)] for _ in range(N)]
answer = math.inf
for x in range(1, N+1):
	for y in range(1, N+1):
		d1 = 1
		while y-d1 >= 1:
			d2 = 1
			while x+d1+d2 <= N and y+d2 <= N:
				answer = min(answer, divide_area(copy.deepcopy(area), x, y, d1, d2))
				d2 += 1
			d1 += 1
print(answer)

