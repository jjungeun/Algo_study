import copy
# 위부터 반시계방향으로 1씩 증가
dr = [-1, -1, 0, 1, 1, 1, 0, -1]
dc = [0, -1, -1, -1, 0, 1, 1, 1]

def move_fish(fish_map, fish):
	for num in range(1, 17):
		if num not in fish.keys():
			continue
		r, c, d = fish[num]
		for i in range(8):
			nr, nc, nd = r+dr[(d+i)%8], c+dc[(d+i)%8], (d+i)%8
			if nr not in range(4) or nc not in range(4) or fish_map[nr][nc] == 0:
				continue
			if fish_map[nr][nc] != -1:
				change_fish = fish_map[nr][nc]
				direct = fish[change_fish][2]
				fish[change_fish] = (r, c, direct)
				fish_map[r][c] = change_fish
			else:
				fish_map[r][c] = -1
			fish_map[nr][nc] = num
			fish[num] = (nr, nc, nd)
			break

def dfs(fish_map, fish, shark, answer):
	new_map = copy.deepcopy(fish_map)
	new_fish = copy.deepcopy(fish)
	sr, sc, sd = shark
	eaten = new_map[sr][sc]
	sd = new_fish[eaten][2]
	eaten_info = new_fish.pop(eaten)
	new_map[sr][sc] = 0
	move_fish(new_map, new_fish)
	max_answer = answer + eaten
	new_map[sr][sc] = -1
	while True:
		sr, sc = sr+dr[sd], sc+dc[sd]
		if sr not in range(4) or sc not in range(4):
			break
		if new_map[sr][sc] < 1:
			continue
		max_answer = max(max_answer, dfs(new_map, new_fish, (sr, sc, sd), answer+eaten))
	return max_answer

fish = {}
idx = 0
fish_map = [[0 for _ in range(4)] for _ in range(4)]
for row in range(4):
	infos = list(map(int, input().split()))
	for i in range(len(infos)//2):
		fish[infos[i*2]] = (row, i, infos[i*2+1]-1)
		fish_map[row][i] = infos[i*2]

print(dfs(fish_map, fish, (0,0,0), 0))
