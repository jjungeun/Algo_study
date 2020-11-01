def getInstall(w, start, end):
	if start >= end:
		return 0
	w_len = w*2+1
	if (end-start) % w_len == 0:
		return (end-start) // w_len
	else:
		return (end-start) // w_len + 1

def solution(n, stations, w):
	answer = 0
	prev = 0
	for s in stations:
		if s <= prev:
			prev = s + w
			continue
		answer += getInstall(w, prev, s-w-1)
		prev = s + w
	if prev <= n-1:
		answer += getInstall(w, prev, n)
	return answer
