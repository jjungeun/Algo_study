from itertools import permutations

def is_fit(case, banned_id):
	for idx in range(len(case)):
		id = case[idx]
		bid = banned_id[idx]
		if len(id) != len(bid):
			return False
		for i in range(len(id)):
			if bid[i] != '*' and bid[i] != id[i]:
				return False
	return True

def solution(user_id, banned_id):
	answer = set()
	case_list = list(permutations(user_id, len(banned_id)))
	for case in case_list:
		if is_fit(case, banned_id) and answer.isdisjoint(tuple(sorted(case))):
			answer.add(tuple(sorted(case)))
	return len(answer)

user_id = ["frodo", "fradi", "crodo", "abc123", "frodoc"]
banned_id = ["fr*d*", "abc1**"]

user_id = ["frodo", "fradi", "crodo", "abc123", "frodoc"]
banned_id = ["*rodo", "*rodo", "******"]

user_id = ["frodo", "fradi", "crodo", "abc123", "frodoc"]
banned_id = ["fr*d*", "*rodo", "******", "******"]

# user_id = ["frodo", "fradi", "crody", "abcdo", "cbcko", "bbcdo", "abc", "cde"]
# banned_id = ["fr*d*", "*rod*", "****o", "****o", "***"]
print(solution(user_id, banned_id))
