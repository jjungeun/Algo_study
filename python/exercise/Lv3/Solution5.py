def makehearing(melody, time):
	hearing = ""
	melody_ls = []
	for m in melody:
		if m == '#':
			melody_ls[-1] += m
		else:
			melody_ls.append(m)
	idx = 0
	for i in range(time):
		hearing += melody_ls[idx]
		idx = idx + 1 if idx + 1 < len(melody_ls) else 0
	return hearing

def init(musicinfos):
	musics = []
	for info in musicinfos:
		music = {}
		detail = info.split(",")
		music['name'] = detail[2]
		music['melody'] = detail[3]
		hour = int(detail[1].split(":")[0]) - int(detail[0].split(":")[0])
		minute = int(detail[1].split(":")[1]) - int(detail[0].split(":")[1])
		music['time'] = hour * 60 + minute
		music['hearing'] = makehearing(music['melody'], music['time'])
		musics.append(music)
	return musics

def ismusic(music, m):
	idx = -1
	for i, v in enumerate(music['melody']):
		if m[0] == v and len(music['hearing']) >= i+len(m):
			if len(m)+i < len(music['hearing']) and music['hearing'][len(m)+i] == "#":
				continue
			if music['hearing'][i:i+len(m)] == m:
				return True
	return False

def solution(m, musicinfos):
	answers = []
	musics = init(musicinfos)
	for music in musics:
		if ismusic(music, m):
			answers.append(music)
	if len(answers) == 0:
		return "(None)"
	answers = sorted(answers, key=lambda k : k['time'], reverse=True)
	return answers[0]['name']

# m = "ABCDEFG"
# musicinfos = ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]

m = "ABC"
musicinfos = ["12:00,12:14,HELLO,C#DEFGAB", "12:00,12:04,HalO,ABCDEF", "13:00,13:05,WORLD,ABCDEF"]

print(solution(m, musicinfos))


# 조건 일치하는게 여러개면 재생시간이 긴 음악, time도 같으면 먼저 입력된 음악
# 없으면 None
