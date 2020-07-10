def solution(msg):
	answer = []
	zip_dict = {}
	word = ""
	for i in range(ord('Z') - ord('A') + 1):
		zip_dict[chr(ord('A') + i)] = i + 1
	for i, m in enumerate(msg):
		word += m
		if i + 1 < len(msg):
			if word + msg[i+1] in zip_dict.keys():
				continue
			answer.append(zip_dict[word])
			zip_dict[word + msg[i + 1]] = len(zip_dict) + 1
			word = ""
		else:
			answer.append(zip_dict[word])
	return answer

msg = "TOBEORNOTTOBEORTOBEORNOT"
print(solution(msg))
