def change_format(lines):
	time = []
	for line in lines:
		line_info = line.split(" ")
		S = list(map(float, line_info[1].split(":")))
		seconds = int((S[0] * 60 * 60 + S[1] * 60 + S[2]) * 1000)
		T = int(float(line_info[2].split("s")[0]) * 1000)
		time.append([seconds - T + 1,seconds])
	return time

def get_traffic(time, section):
	traffic = 0
	start = section[1]
	end = start + 1000 - 1
	for i in range(len(time)):
		if time[i][0] > end or time[i][1] < start:
			continue
		traffic += 1
	return traffic

def solution(lines):
	answer = 0
	time = change_format(lines)
	for section in time:
		traffic = get_traffic(time, section)
		answer = traffic if answer < traffic else answer
	return answer

lines = [
"2016-09-15 20:59:57.421 0.351s",
"2016-09-15 20:59:58.233 1.181s",
"2016-09-15 20:59:58.299 0.8s",
"2016-09-15 20:59:58.688 1.041s",
"2016-09-15 20:59:59.591 1.412s",
"2016-09-15 21:00:00.464 1.466s",
"2016-09-15 21:00:00.741 1.581s",
"2016-09-15 21:00:00.748 2.31s",
"2016-09-15 21:00:00.966 0.381s",
"2016-09-15 21:00:02.066 2.62s"
]
print(solution(lines))
