import sys
sys.stdin = open("input.txt", "r")

class Node:
	def __init__(self, data, leaf=False):
		self.data = data
		self.next = None

class HashTable:
	def __init__(self, table_size):
		self.size = table_size
		self.hash_table = [None for _ in range(self.size)]

	def getKey(self, data):
		return data % self.size

	def add(self, data):
		key = self.getKey(data)
		if self.hash_table[key] == None:
			self.hash_table[key] = Node(data)
		else:
			cur = self.hash_table[key]
			while cur.next:
				cur = cur.next
			cur.next = Node(data)

	def hasData(self, data):
		key = self.getKey(data)
		if self.hash_table[key] == None:
			return 0
		cur = self.hash_table[key]
		while cur:
			if cur.data == data:
				return 1
			cur = cur.next
		return 0


HASH_SIZE = 10002
ht = HashTable(HASH_SIZE)
N = int(input())
num = list(map(int, input().split()))
for n in num:
	ht.add(n)
M = int(input())
query = list(map(int, input().split()))
for q in query:
	print(ht.hasData(q))
