def solution(N, simulation_data):
	answer = 0
	worker = [0 for _ in range(N)]
	idx = 0
	while idx < len(simulation_data):
		client = simulation_data[idx]
		wid = worker.index(min(worker))
		if min(worker) > client[0]:
			answer += min(worker) - client[0]
			worker[wid] += client[1]
		else:
			worker[wid] = client[0] + client[1]
		idx += 1
	return answer

N = 2
data = [[0, 3], [2, 5], [4, 2], [5, 3]]
print(solution(N, data))
