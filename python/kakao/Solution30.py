class Node:
	def __init__(self, val, leaf=False):
		self.val = val
		self.leaf = leaf
		self.cnt = 0
		self.child = {}

class Trie:
	def __init__(self):
		self.head = Node(None)

	def insert(self, new_str):
		cur = self.head
		for c in new_str:
			if c not in cur.child:
				cur.child[c] = Node(c)
			cur.cnt += 1
			cur = cur.child[c]
		cur.cnt += 1
		cur.leaf = True

	def search(self, prefix):
		ret = 0
		cur = self.head
		for c in prefix:
			if c in cur.child:
				cur = cur.child[c]
			else:
				return 0

		node_list = []
		for c in cur.child:
			node_list.append(cur.child[c])

		for i in node_list:
			ret += i.cnt
		return ret

def solution(words, queries):
	answer = []

	trie = [Trie() for i in range(10000)]
	reverse = [Trie() for i in range(10000)]

	for w in words:
		trie[len(w) - 1].insert(w)
		reverse[len(w) - 1].insert(w[::-1])

	for query in queries:
		is_rev = False
		if query[0] == '?' and query[-1] != '?':
			is_rev = True
			query = query[::-1]

		pre = 0
		for idx, c in enumerate(query):
			if c == '?':
				pre = idx
				break

		if is_rev:
			answer.append(reverse[len(query) - 1].search(query[:pre]))
		else:
			answer.append(trie[len(query)-1].search(query[:pre]))
	return answer

# def get_len_dict(words):
# 	len_dict = {}
# 	for word in words:
# 		word_len = len(word)
# 		if word_len in len_dict.keys():
# 			len_dict[word_len].append(word)
# 		else:
# 			len_dict[word_len] = [word]
# 	return len_dict

# def is_fit(query, query_len, word, is_rev):
# 	if (is_rev):
# 		for idx in range(query_len-1, -1, -1):
# 			if query[idx] == '?':
# 				return 1
# 			elif query[idx] != word[idx]:
# 				return 0
# 	else:
# 		for idx in range(query_len):
# 			if query[idx] == '?':
# 				return 1
# 			elif query[idx] != word[idx]:
# 				return 0

# def get_word(query, query_len, len_dict):
# 	word_cnt = 0
# 	word_list = len_dict[query_len]
# 	is_rev = query[0] == '?'
# 	for word in word_list:
# 		word_cnt += is_fit(query, query_len, word, is_rev)
# 	return word_cnt

# def solution(words, queries):
# 	answer = []
# 	len_dict = get_len_dict(words)
# 	answer_dict = {}
# 	for query in queries:
# 		query_len = len(query)
# 		if query in answer_dict.keys():
# 			answer.append(answer_dict[query])
# 		elif query_len not in len_dict.keys():
# 			answer.append(0)
# 		else:
# 			word_cnt = get_word(query, query_len, len_dict)
# 			answer.append(word_cnt)
# 			answer_dict[query] = word_cnt
# 	return answer
