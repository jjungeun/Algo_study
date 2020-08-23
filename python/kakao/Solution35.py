class heap:
	def __init__(self):
		self.queue = [-1]

	def swap(self, idx1, idx2):
		tmp = self.queue[idx1]
		self.queue[idx1] = self.queue[idx2]
		self.queue[idx2] = tmp

	def insert(self, value):
		q = self.queue
		q.append(value)
		idx = len(q) - 1
		while idx > 1:
			min_idx = idx//2
			for i in range(idx//2, idx):
				min_idx = i if q[i] < q[min_idx] else min_idx
			if q[min_idx] < q[idx]:
				self.swap(idx, min_idx)
				idx = min_idx
			else:
				break

	def delete_max(self):
		q = self.queue
		for i in range(2, len(q)):
			q[i-1] = q[i]
		q.pop()

	def delete_min(self):
		self.queue.pop()

def solution(operations):
	answer = []
	max_heap = heap()
	for oper in operations:
		cmd, value = oper.split(' ')
		if cmd == 'I':
			max_heap.insert(int(value))
		elif cmd == 'D' and len(max_heap.queue) > 1:
			if value == '1':
				max_heap.delete_max()
			else:
				max_heap.delete_min()
	if len(max_heap.queue) == 1:
		answer = [0,0]
	else:
		answer = [max_heap.queue[1], max_heap.queue[len(max_heap.queue)-1]]
	return answer

operations = ["I 5", "I 5", "D 1","I 7", "D -1", "I 8"]
print(solution(operations))
