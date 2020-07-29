def change_format(timetable):
	minute_table = []
	for t in timetable:
		time = t.split(":")
		minute_table.append(int(time[0]) * 60 + int(time[1]))
	return sorted(minute_table)

def get_bustime(n, t):
	bus_table = []
	for i in range(n):
		bus_table.append(9 * 60 + i * t)
	return bus_table

def boarding_sum(time_table, arrive_time, boarding_people):
	idx = boarding_people
	while idx < len(time_table):
		if not time_table[idx] <= arrive_time:
			break
		idx += 1
	return idx - boarding_people

def solution(n, t, m, timetable):
	answer = 0
	time_table = change_format(timetable)
	bus_table = get_bustime(n, t)
	boarding_people = 0
	for idx, arrive_time in enumerate(bus_table):
		this_time = boarding_sum(time_table, arrive_time, boarding_people)
		if idx == len(bus_table) - 1:
			if this_time < m:
				answer = arrive_time
			else:
				answer = time_table[boarding_people + m - 1] - 1
			break
		boarding_people += this_time if this_time <= m else m
	return "%02d:%02d" % (answer // 60, answer % 60)

# n = 2
# t = 10
# m = 2
# timetable = ["09:10", "09:09", "08:00"]

# n = 2
# t = 1
# m = 2
# timetable = ["09:00", "09:00", "09:00", "09:00"]

n = 1
t = 1
m = 5
timetable = ["00:01", "00:01", "00:01", "00:01", "00:01"]

# n = 10
# t = 60
# m = 45
# timetable = ["23:59","23:59","23:59","23:59"]
print(solution(n, t, m, timetable))
