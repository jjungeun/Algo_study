def dfs(start, tickets, visited, answer):
	if 0 not in visited:
		return True
	for idx, ticket in enumerate(tickets):
		if visited[idx] == 0 and start == ticket[0]:
			visited[idx] = 1
			if dfs(ticket[1], tickets, visited, answer):
				answer.insert(1, ticket[1])
				return True
			else:
				visited[idx] = 0
	return False

def solution(tickets):
	answer = ["ICN"]
	visited = [0 for _ in range(len(tickets))]
	tickets = sorted(tickets, key=lambda x: x[1])
	dfs("ICN", tickets, visited, answer)
	return answer

# tickets = [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]
tickets = [["ICN", "C"], ["C", "ICN"], ["ICN", "C"]]
# tickets = [["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]
# tickets = [["ICN", "B"], ["ICN", "C"], ["C", "D"], ["D", "C"], ["B", "D"], ["D", "B"], ["B", "ICN"], ["C", "B"]]
print(solution(tickets))
