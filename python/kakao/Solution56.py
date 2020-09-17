dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]

def check_in(rpos, bpos, hpos, direct):
	rr, rc = rpos
	br, bc = bpos
	red_in = False
	blue_in = False
	# 벽만나거나 구멍에 들어갈때
	while board[rr+dr[direct]][rc+dc[direct]] != 1:
		rr += dr[direct]
		rc += dc[direct]
		if (rr, rc) == hpos:
			red_in = True
	while board[br+dr[direct]][bc+dc[direct]] != 1:
		br += dr[direct]
		bc += dc[direct]
		if (br, bc) == hpos:
			blue_in = True
	if blue_in:
		return -1
	elif not blue_in and red_in:
		return 1
	else:
		return 0

def tilt(rpos, bpos, direct):
	rr, rc = rpos
	br, bc = bpos
	prev = ((), ())
	while True:
		while board[rr+dr[direct]][rc+dc[direct]] != 1 and (rr+dr[direct], rc+dc[direct]) != (br, bc):
			rr += dr[direct]
			rc += dc[direct]
		while board[br+dr[direct]][bc+dc[direct]] != 1 and (br+dr[direct], bc+dc[direct]) != (rr, rc):
			br += dr[direct]
			bc += dc[direct]
		if ((rr, rc), (br, bc)) == prev:
			break
		prev = ((rr, rc),(br, bc))
	return (rr, rc), (br, bc)

def do_game(rpos, bpos, hpos, depth, direct):
	answer = 11
	if depth > 10:
		return -1
	# direct방향으로 기울였을때 hole에 들어가는지 검사
	ret = check_in(rpos, bpos, hpos, direct)
	if ret == -1:
		return -1
	elif ret == 1:
		return depth
	new_rpos, new_bpos = tilt(rpos, bpos, direct)
	if new_rpos == rpos and new_bpos == bpos:
		return -1
	# 온 방향, 온방향 반대방향 빼고
	for i in range(2):
		d = 2 if direct < 2 else 0
		new_path = do_game(new_rpos, new_bpos, hpos, depth+1, (d+i)%4)
		if new_path != -1:
			answer = min(answer, new_path)
	return answer


N, M = map(int,input().split(' '))
board = []
rpos, bpos, hpos = (), (), ()
for i in range(N):
	row_str = input()
	row = []
	for j in range(M):
		if row_str[j] == '#':
			row.append(1)
		else:
			if row_str[j] == 'R':
				rpos = (i, j)
			elif row_str[j] == 'B':
				bpos = (i, j)
			elif row_str[j] == 'O':
				hpos = (i, j)
			row.append(0)
	board.append(row)
answer = 11
for i in range(4):
	path = do_game(rpos, bpos, hpos, 1, i)
	if path != -1:
		answer = min(answer, path)
print(answer if answer <= 10 else -1)
