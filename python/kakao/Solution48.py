def next_node(n, relation, visited):
	min_value = 1001
	node = -1
	for i in range(n):
		if not visited[i] and relation[i] < min_value:
			node = i
	return node+1

def search(n, c, coms):
	infected, max_cost = 0, 0
	relation = [1001 for _ in range(n)]
	visited = [False for _ in range(n)]
	relation[c-1] = 0
	while True:
		visited[c-1] = True
		infected += 1
		for com in coms:
			c1, c2, cost = com
			if c2 == c:
				relation[c1-1] = min(relation[c1-1], relation[c-1]+cost)
		c = next_node(n, relation, visited)
		if c == 0:
			break
	for cost in relation:
		if cost != 1001:
			max_cost = max(max_cost, cost)
	print(infected, max_cost)

N = int(input())
for _ in range(N):
	n, d, c = list(map(int, input().split(' ')))
	coms = []
	for _ in range(d):
		coms.append(list(map(int, input().split(' '))))
	search(n, c, coms)
