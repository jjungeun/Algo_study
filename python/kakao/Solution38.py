def solution(routes):
	answer = 0
	checked = [0 for _ in range(len(routes))]
	routes = sorted(routes, key=lambda k:k[0])
	std_pos = 0
	while 0 in checked:
		if checked[std_pos] == 0:
			pos = routes[std_pos][1]
			for idx in range(std_pos+1, len(routes)):
				if routes[idx][0] <= pos:
					checked[idx] = 1
					pos = min(routes[idx][1], pos)
				else:
					break
			checked[std_pos] = 1
			answer += 1
		std_pos += 1
	return answer

print(solution([[-20,-15], [-14,-5], [-18,-13], [-5,-3]]))
