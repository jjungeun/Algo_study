def change(begin, word):
	diff = 0
	if begin == word:
		return False
	for i,v in enumerate(begin):
		diff += 1 if v != word[i] else 0
		if diff > 1:
			return False
	return True

def dfs(now, target, words, sum):
	if target in words and change(now, target):
		return sum + 1
	for idx, word in enumerate(words):
		if change(now, word):
			ret = dfs(word, target, words[:idx] + words[idx + 1 :], sum+1)
			if ret != 0:
				return ret
	return 0

def solution(begin, target, words):
	if target not in words:
		return 0
	answer = dfs(begin, target, words, 0)
	return answer

begin = "hit"
target = "cog"
words = ["hot", "dot", "dog", "lot", "log", "cog"]
ans = solution(begin, target, words)
print(ans)
