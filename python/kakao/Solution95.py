class Node:
	def __init__(self, data):
		self.data = data
		self.left, self.right = None, None

class BinarySearchTree:
	def __init__(self):
		self.root = None

	def insert(self, data):
		if self.root == None:
			self.root = Node(data)
		else:
			cur = self.root
			while True:
				if data < cur.data:
					if cur.left == None:
						cur.left = Node(data)
						break
					cur = cur.left
				else:
					if cur.right == None:
						cur.right = Node(data)
						break
					cur = cur.right

	def find(self, data):
		cur = self.root
		while cur != None:
			if cur.data == data:
				return True
			elif cur.data < data:
				cur = cur.right
			else:
				cur = cur.left
		return False

	def delete(self, key):
		self.root, deleted = self._delete_value(self.root, key)
		return deleted

	def _delete_value(self, node, key):
		if node is None:
			return node, False

		deleted = False
		if key == node.data:
			deleted = True
			if node.left and node.right:
				# replace the node to the leftmost of node.right
				parent, child = node, node.right
				while child.left is not None:
					parent, child = child, child.left
				child.left = node.left
				if parent != node:
					parent.left = child.right
					child.right = node.right
				node = child
			elif node.left or node.right:
				node = node.left or node.right
			else:
				node = None
		elif key < node.data:
			node.left, deleted = self._delete_value(node.left, key)
		else:
			node.right, deleted = self._delete_value(node.right, key)
		return node, deleted



array = [40, 4, 34, 45, 14, 55, 48, 13, 15, 49, 47]
bst = BinarySearchTree()
for x in array:
	bst.insert(x)

print(bst.delete(4))
print(bst.find(4))
print(bst.find(16))
