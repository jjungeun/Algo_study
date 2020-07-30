import sys
sys.setrecursionlimit(10**6)

class Tree:
	def __init__(self, nodeinfo):
		self.data = max(nodeinfo, key=lambda k:k[1])
		left_nodes = list(filter(lambda k:k[0] < self.data[0], nodeinfo))
		right_nodes = list(filter(lambda k:k[0] > self.data[0], nodeinfo))

		if left_nodes != []:
			self.left = Tree(left_nodes)
		else:
			self.left = None

		if right_nodes != []:
			self.right = Tree(right_nodes)
		else:
			self.right = None

def do_search(node, pre_nodes, post_nodes):
	pre_nodes.append(node.data)
	if node.left:
		do_search(node.left, pre_nodes, post_nodes)
	if node.right:
		do_search(node.right, pre_nodes, post_nodes)
	post_nodes.append(node.data)

def solution(nodeinfo):
	answer = []
	root = Tree(nodeinfo)
	pre_nodes = []
	post_nodes = []
	do_search(root, pre_nodes, post_nodes)
	answer.append(list(map(lambda x: nodeinfo.index(x)+1 ,pre_nodes)))
	answer.append(list(map(lambda x: nodeinfo.index(x)+1 ,post_nodes)))
	return answer

nodeinfo = [[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]
print(solution(nodeinfo))
# print(solution(nodeinfo))
