import sys
sys.stdin = open("input.txt", "r")

class Node:
	def __init__(self, data, leaf=False):
		self.data = data
		self.leaf = leaf
		self.child = {}
		self.cnt = 0

class Trie:
	def __init__(self, alpha):
		self.root = Node(alpha, True)

	def add(self, new_str):
		cur = self.root
		for c in new_str[1:]:
			if c not in cur.child:
				cur.child[c] = Node(c, True)
			cur.cnt += 1
			cur.leaf = False
			cur = cur.child[c]
		cur.cnt += 1

	def search(self, query, sidx):
		cur = self.root
		for idx in range(sidx+1, len(query)):
			c = query[idx]
			if c not in cur.child.keys():
				return False
			cur = cur.child.get(c)
			if cur.leaf:
				return True
		return False

if __name__=="__main__":
	N = int(sys.stdin.readline().strip('\n'))
	sub_set = [sys.stdin.readline().strip('\n') for _ in range(N)]
	Q = int(sys.stdin.readline().strip('\n'))
	query_set = [sys.stdin.readline().strip('\n') for _ in range(Q)]
	trie = []
	for alpha in range(ord('z') - ord('a') + 1):
		trie.append(Trie((chr)(ord('a')+alpha)))
	for sub in sub_set:
		idx = ord(sub[0]) - ord('a')
		trie[idx].add(sub)

	for query in query_set:
		is_sub = False
		for sidx in range(len(query)):
			idx = ord(query[sidx]) - ord('a')
			if trie[idx].search(query, sidx):
				is_sub = True
				break
		if is_sub:
			print("YES")
		else:
			print("NO")

