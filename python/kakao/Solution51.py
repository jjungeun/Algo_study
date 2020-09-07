from collections import deque

def get_relation(edge):
	relation = {}
	for e1, e2 in edge:
		if e1 in relation.keys():
			relation[e1].append(e2)
		else:
			relation[e1] = [e2]
		if e2 in relation.keys():
			relation[e2].append(e1)
		else:
			relation[e2] = [e1]
	return relation

def solution(n, edge):
	answer = 0
	relation = get_relation(edge)
	dist = [n for _ in range(n+1)]
	dist[0] = -1
	visited = [False for _ in range(n+1)]
	q = deque()
	q.append((1, 0))
	while q:
		node, time = q.popleft()
		dist[node] = min(time, dist[node])
		if node not in relation.keys():
			continue
		for next in relation[node]:
			if not visited[next]:
				visited[next] = True
				q.append((next, time+1))

	max_value = max(dist)
	for d in dist:
		if max_value == d:
			answer += 1
	return answer

n = 6
vertex = [[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]
print(solution(n, vertex))
