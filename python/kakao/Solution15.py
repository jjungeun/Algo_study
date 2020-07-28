def get_head(file):
	idx = 0
	num_idx = 0
	while idx < len(file):
		if num_idx == 0 and file[idx].isnumeric():
			num_idx = idx
		elif num_idx != 0 and not file[idx].isnumeric():
			break
		idx += 1
	return file[:num_idx].upper(), int(file[num_idx:idx])

def solution(files):
	answer = []
	heads = {}
	for idx, file_name in enumerate(files):
		file_head, num = get_head(file_name)
		if file_head in heads.keys():
			heads[file_head] += [(idx, num)]
		else:
			heads[file_head] = [(idx, num)]
	for head in sorted(heads.keys()):
		heads[head] = sorted(heads[head], key=lambda k: k[1])
		answer += [files[file[0]] for file in heads[head]]
	return answer

files = ["img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"]
# files = ["F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"]
print(solution(files))
