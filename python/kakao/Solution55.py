def get_count(trees, cut_height):
	idx = 0
	cnt = 0
	while idx < len(trees):
		if trees[idx] <= cut_height:
			break
		cnt += trees[idx] - cut_height
		idx += 1
	return cnt

def cut(N, M, trees):
	start = 0
	end = trees[0]
	answer = 0
	while start < end:
		mid = (start + end) // 2
		cnt = get_count(trees, mid)
		if cnt == M or start == mid or end == mid:
			answer = mid
			break
		elif cnt < M:
			end = mid
		else:
			start = mid
	return answer

N, M = list(map(int, input().split()))
trees = list(map(int, input().split()))
trees = sorted(trees, reverse=True)
print(cut(N, M, trees))
