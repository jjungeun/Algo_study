from collections import defaultdict
from collections import deque

vertex = [[1,2],[1,3],[1,4],[4,3],[3,2],[2,5],[3,5],[5,7],
[5,6], [6,7],[7,8]]
info = defaultdict(list)
vcnt = defaultdict(int)
N = 8
sort_ls = []
# 초기화
for v in vertex:
	s, e = v
	info[s].append(e)
	vcnt[s] += 0
	vcnt[e] += 1

# 초기노드 넣기
q = deque()
for node in vcnt.keys():
	if vcnt[node] == 0:
		q.append(node)

while q:
	node = q.popleft()
	sort_ls.append(node)
	for next in info[node]:
		vcnt[next] -= 1
		if vcnt[next] == 0:
			q.append(next)

print(sort_ls)
