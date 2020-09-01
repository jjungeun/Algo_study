def solution(people, limit):
	answer = 0
	people = sorted(people, reverse=True)
	left = 0
	right = len(people) - 1
	while left <= right:
		if people[left] + people[right] <= limit:
			right -= 1
		left += 1
		answer += 1
	return answer

people = [70, 80, 50]
limit = 100
print(solution(people, limit))
