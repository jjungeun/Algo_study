from itertools import combinations, permutations
import copy

def comb(lst, n):
	ret = []
	if n > len(lst):
		return ret
	if n == 1:
		for i in lst:
			ret.append([i])
	elif n > 1:
		for i in range(len(lst)-n+1):
			for t in comb(lst[i+1:], n-1):
				ret.append([lst[i]] + t)
	return ret

def perm(lst, n):
	ret = []
	if n > len(lst):
		return ret
	if n == 1:
		for i in lst:
			ret.append([i])
	elif n > 1:
		for i in range(len(lst)):
			tmp = copy.deepcopy(lst)
			data = tmp.pop(i)
			for t in perm(tmp, n-1):
				ret.append([data]+t)
	return ret

arr = [1,2,3,4]
print(list(combinations(arr, 3)))
print(comb(arr, 3))
print(list(permutations(arr, 2)))
print(perm(arr, 2))
