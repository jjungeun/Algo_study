import sys
sys.stdin = open("input.txt", "r")

class Stack:
	def __init__(self):
		self.items = []

	def push(self, node):
		self.items.append(node)

	def pop(self):
		if self.empty():
			return -1
		return self.items.pop()

	def size(self):
		return len(self.items)

	def empty(self):
		return 1 if self.size() == 0 else 0

	def top(self):
		if self.empty():
			return -1
		return self.items[-1]

N = int(int(sys.stdin.readline().strip('\n')))
stack = Stack()
for _ in range(N):
	cmd = sys.stdin.readline().strip('\n').split()
	if len(cmd) == 2:
		stack.push(int(cmd[1]))
	elif cmd[0] == 'pop':
		print(stack.pop())
	elif cmd[0] == 'size':
		print(stack.size())
	elif cmd[0] == 'empty':
		print(stack.empty())
	else:
		print(stack.top())
