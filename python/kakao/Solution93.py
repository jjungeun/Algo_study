def time_log(original_fn):
	import time
	def wrapper_fn(*args, **kwargs):
		start_time = time.time()
		result = original_fn(*args, **kwargs)
		end_time = time.time()
		print(f"Working Time [{original_fn.__name__}]: {end_time-start_time}")
		return result
	return wrapper_fn

def swap(arr, idx1, idx2):
	tmp = arr[idx1]
	arr[idx1] = arr[idx2]
	arr[idx2] = tmp

@time_log
def bubble(arr):
	sort_cnt = 0
	while sort_cnt < len(arr):
		for idx in range(len(arr)-sort_cnt-1):
			if arr[idx] > arr[idx+1]:
				swap(arr, idx, idx+1)
		sort_cnt += 1
	return arr

# 버블소트랑 비슷하지만 하나 지정해서 앞에 정렬된 순서에 넣는 식
@time_log
def insert(arr):
	key = 1
	while key < len(arr):
		key_value = arr[key]
		i = key-1
		while i >= 0:
			if arr[i] <= key_value:
				break
			arr[i+1] = arr[i]
			i-=1
		arr[i+1] = key_value
		key += 1
	return arr

@time_log
def select(arr):
	cnt = 0
	while cnt < len(arr)-1:
		min_idx = cnt
		min_value = arr[cnt]
		for idx in range(cnt+1, len(arr)):
			if arr[idx] < min_value:
				min_idx = idx
				min_value = arr[idx]
		swap(arr, cnt, min_idx)
		cnt += 1
	return arr

@time_log
def merge(arr):
	if len(arr) <= 1:
		return arr
	mid = len(arr)//2
	left, right = merge(arr[:mid]), merge(arr[mid:])
	ret = []
	lidx, ridx = 0, 0
	while lidx < len(left) and ridx < len(right):
		if left[lidx] <= right[ridx]:
			ret.append(left[lidx])
			lidx += 1
		else:
			ret.append(right[ridx])
			ridx += 1
	if lidx < len(left):
		ret += left[lidx:]
	elif ridx < len(right):
		ret += right[ridx:]
	return ret

# 인덱스 두개로 정렬하는 방식
@time_log
def quick(arr):
	if len(arr) <= 1:
		return arr
	pivot = len(arr)-1
	lidx, ridx = 0, pivot-1
	while True:
		while ridx >= 0 and arr[ridx] >= arr[pivot]:
			ridx -= 1
		while lidx < len(arr) and arr[lidx] <= arr[pivot]:
			lidx += 1
		if lidx < ridx:
			swap(arr, lidx, ridx)
		else:
			break
	if lidx < len(arr):
		swap(arr, lidx, pivot)
		return quick(arr[:lidx]) + [arr[lidx]] + quick(arr[lidx+1:])
	else:
		return arr

@time_log
def radix(arr):
	max_value = max(arr)
	digit = 1
	while max_value // digit != 0:
		radix = [[] for _ in range(10)]
		new_arr = []
		for i in arr:
			ch_digit = i // digit
			radix[ch_digit % (digit*10)].append(i)
		for i in radix:
			new_arr += i
		arr = new_arr
		digit *= 10
	return arr

import math
class Heap:
	def __init__(self, size):
		self.queue = [-1]

	def add(self, data):
		q = self.queue
		q.append(data)
		idx = len(q) - 1
		while idx > 1:
			pidx = idx // 2
			if q[idx] < q[pidx]:
				swap(q, idx, pidx)
			else:
				break
			idx = pidx

	def pop(self):
		q = self.queue
		idx = len(q) - 1
		swap(q, 1, idx)
		min_value = q.pop()
		self.min_heapify(1)
		return min_value

	def min_heapify(self, idx):
		q = self.queue
		lidx, ridx = self.left(idx), self.right(idx)
		min_idx = idx
		if lidx != -1 and q[lidx] < q[min_idx]:
			min_idx = lidx
		if ridx != -1 and q[ridx] < q[min_idx]:
			min_idx = ridx
		if idx != min_idx:
			swap(q, idx, min_idx)
			self.min_heapify(min_idx)

	def left(self, idx):
		if idx * 2 < len(self.queue):
			return idx * 2
		return -1

	def right(self, idx):
		if idx * 2 + 1 < len(self.queue):
			return idx * 2 + 1
		return -1

@time_log
def heapify(arr):
	heap = Heap(len(arr))
	for i in arr:
		heap.add(i)
	ret = []
	for _ in range(len(arr)):
		ret.append(heap.pop())
	return ret


# arr = [13,7,21,5,19,1]
# print(bubble(arr))
# arr = [13,7,21,5,19,1]
# print(insert(arr))
# arr = [13,7,21,5,19,1]
# print(select(arr))
# arr = [13,7,21,5,19,1]
# print(merge(arr))
# arr = [13,7,21,5,19,1]
# print(quick(arr))
# arr = [13,7,21,5,19,1]
# print(radix(arr))
# arr = [13,7,21,5,19,1]
# print(heapify(arr))
