def solution(gems):
	gem_kind = len(set(gems))
	short_len = len(gems)
	start = 0
	end = 0
	for idx in range(len(gems)):
		if len(set(gems[idx:idx+gem_kind])) == gem_kind:
			start = idx
			end = start + gem_kind - 1
			break
		for tmp in range(idx+gem_kind, len(gems)):
			if len(set(gems[idx:tmp+1])) == gem_kind:
				start = idx
				end = tmp
				short_len = end - start
				break
			elif tmp - idx == short_len:
				break

	return [start+1, end+1]

gems = 	["XYZ", "XYZ", "XYZ"]
print(solution(gems))
