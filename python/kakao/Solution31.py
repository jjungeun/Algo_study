class Node:
	def __init__(self, key):
		self.key = key
		self.cnt = 0
		self.child = {}

class Trie:
	def __init__(self, alpha):
		self.root = Node(alpha)
		self.cur = self.root

	def add(self, new_str):
		cur = self.cur
		for c in new_str[1:]:
			if c not in cur.child:
				cur.child[c] = Node(c)
			cur.cnt += 1
			cur = cur.child[c]
		cur.cnt += 1

	def search(self, string):
		typing = 1
		cur = self.cur
		for c in string[1:]:
			if	cur.cnt == 1:
				break
			cur = cur.child[c]
			typing += 1
		return typing

def solution(words):
	answer = 0
	tree = []
	# 알파벳별 트리 생성
	for idx in range(0, ord('z')-ord('a')+1):
		alpha = chr(ord('a')+idx)
		tree.append(Trie(alpha))

	# 트리 생성
	for word in words:
		idx = ord(word[0])-ord('a')
		tree[idx].add(word)

	# 조회
	for word in words:
		idx = ord(word[0])-ord('a')
		answer += tree[idx].search(word)
	return answer

words = ["word","war","warrior","world","g"]
print(solution(words))
