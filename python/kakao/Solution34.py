class Node:
	def __init__(self, job):
		self.start = job[0]
		self.take = job[1]

class heap:
	def __init__(self):
		self.queue = [-1]

	def swap(self, idx1, idx2):
		tmp = self.queue[idx1]
		self.queue[idx1] = self.queue[idx2]
		self.queue[idx2] = tmp

	def insert(self, job):
		self.queue.append(Node(job))
		idx = len(self.queue) - 1
		while idx > 1:
			if self.queue[idx // 2].take > job[1]:
				self.swap(idx//2, idx)
				idx = idx // 2
			else:
				break

	def delete(self):
		idx = len(self.queue) - 1
		self.swap(1, idx)
		min_node = self.queue.pop()
		self.min_heapify(1)
		return min_node

	def min_heapify(self, idx):
		left_idx = self.leftchild(idx)
		right_idx = self.rightchild(idx)
		min_idx = idx

		if left_idx != -1 and self.queue[left_idx].take < self.queue[min_idx].take:
			min_idx = left_idx
		if right_idx != -1 and self.queue[right_idx].take < self.queue[min_idx].take:
			min_idx = right_idx

		if min_idx != idx:
			self.swap(idx, min_idx)
			self.min_heapify(min_idx)

	def leftchild(self, idx):
		if idx * 2 < len(self.queue):
			return idx * 2
		return -1

	def rightchild(self, idx):
		if idx * 2 + 1 < len(self.queue):
			return idx * 2 + 1
		return -1

def solution(jobs):
	answer = 0
	job_num = len(jobs)
	jobs = sorted(jobs, key=lambda k: k[0])
	time = 0
	min_heap = heap()
	while len(jobs) > 0 or len(min_heap.queue) > 1:
		while len(jobs) > 0:
			if jobs[0][0] <= time:
				min_heap.insert(jobs.pop(0))
			else:
				break

		if len(min_heap.queue) > 1:
			do_job = min_heap.delete()
			print(do_job.start, do_job.take)
			answer += do_job.take + time - do_job.start
			time += do_job.take
		else:
			time += 1
	return answer // job_num

jobs = [[24, 10], [18, 39], [34, 20], [37, 5], [47, 22], [20, 47], [15, 34], [15, 2], [35, 43], [26, 1]]
print(solution(jobs))
