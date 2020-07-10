def solution(cacheSize, cities):
	answer = 0
	cache = []
	for value in cities:
		city = value.lower()
		if city in cache:
			idx = cache.index(city)
			answer += 1
			cache.pop(idx)
			cache.append(city)
		else:
			answer += 5
			cache.append(city)
			if len(cache) > cacheSize:
				cache.pop(0)
	return answer

cities = ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]
cacheSize = 3
print(solution(cacheSize, cities))
