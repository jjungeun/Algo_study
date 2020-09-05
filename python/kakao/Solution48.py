import sys
from heapq import heappush, heappop
INF = float('inf')

def hacking(relation, dist, start):
	heap = []
	dist[start] = 0
	heappush(heap, [dist[start], start])
	while heap:
		cur_dist, cur_idx = heappop(heap)
		if cur_idx not in relation.keys():
			continue
		for k, v in relation[cur_idx].items():
			distance = cur_dist + v
			if dist[k] > distance:
				dist[k] = distance
				heappush(heap, [dist[k], k])
	return dist

N = int(input())
for _ in range(N):
	V, tc, c = map(int, sys.stdin.readline().split())
	relation = {}
	dist = [INF for _ in range(V+1)]
	for _ in range(tc):
		end, start, distance = map(int, sys.stdin.readline().split())
		if start in relation.keys():
			relation[start][end] = distance
		else:
			relation[start] = {end: distance}
	dist = hacking(relation, dist, c)

	infected = 0
	final_infect = 0
	for d in dist:
		if d != INF:
			infected += 1
			final_infect = max(final_infect, d)
	print(infected, final_infect)
