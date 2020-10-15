import sys
sys.stdin = open("input.txt", "r")

import copy
from collections import deque

def area_diff(area):
	if 0 not in area or 1 not in area:
		return -1
	red_idx = area.index(0)
	blue_idx = area.index(1)
	visited = [False for _ in range(N)]
	cnt = [people[red_idx], people[blue_idx]]
	q = deque()
	q.append((red_idx, 0))
	q.append((blue_idx, 1))
	visited[red_idx] = True
	visited[blue_idx] = True
	while q:
		idx, color = q.popleft()
		for next in area_info[idx+1]:
			next_idx = next-1
			if area[next_idx] == color and not visited[next_idx]:
				cnt[color] += people[next_idx]
				q.append((next_idx, color))
				visited[next_idx] = True
	if False in visited:
		return -1
	return abs(cnt[0] - cnt[1])

def divide(area, area_num):
	if area_num == N:
		return area_diff(area)
	min_answer = 100 * N
	new_area = copy.deepcopy(area)
	for n in range(2):
		new_area[area_num] = n
		diff = divide(new_area, area_num+1)
		if diff != -1:
			min_answer = min(min_answer, diff)
	return min_answer if min_answer != 100 * N else -1

N = int(input())
people = list(map(int, input().split()))
area_info = {}
alone_area = []
for i in range(N):
	area_info[i+1] = list(map(int, input().split()))[1:]
	if area_info[i+1] == []:
		alone_area.append(i)
print(divide([-1 for _ in range(N)], 0))
