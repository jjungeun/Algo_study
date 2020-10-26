import sys
sys.stdin = open("input.txt", "r")

N, M = map(int, input().split())
nodes = list(map(int, input().split()))

class Node:
	def __init__(self, data):
		self.data = data
		self.left = None
		self.right = None

class LinkedList:
	def __init__(self):
		self.head = None
		self.tail = None

	def append(self, new_node):
		if self.head == None:
			self.head = new_node
			self.tail = new_node
		else:
			self.tail.right = new_node
			new_node.left = self.tail
			self.tail = new_node
			self.head.left = new_node
			new_node.right = self.head

	def pop_first(self):
		pop_node = self.head
		self.head = self.head.right
		if self.tail:
			self.tail.right = self.head
		if self.head:
			self.head.left = self.tail
		return pop_node

	def head_dist(self, data):
		cur = self.head
		dist = 0
		while True:
			if cur.data == data:
				return dist
			if cur == self.tail:
				break
			cur = cur.right
			dist += 1
		return -1

	def tail_dist(self, data):
		cur = self.tail
		dist = 0
		while True:
			if cur.data == data:
				return dist
			if cur == self.head:
				break
			cur = cur.left
			dist += 1
		return -1

	def move_right(self, dist):
		for _ in range(dist):
			self.tail = self.head
			self.head = self.head.right

	def move_left(self, dist):
		for _ in range(dist):
			self.head = self.tail
			self.tail = self.tail.left

if __name__ == "__main__":
	linked_list = LinkedList()
	for data in range(N):
		linked_list.append(Node(data))

	answer = 0
	for node in nodes:
		node_data = node-1
		head_dist = linked_list.head_dist(node_data)
		tail_dist = linked_list.tail_dist(node_data)
		if head_dist <= tail_dist:
			linked_list.move_right(head_dist)
			answer += head_dist
		else:
			linked_list.move_left(tail_dist+1)
			answer += tail_dist+1
		linked_list.pop_first()
	print(answer)
