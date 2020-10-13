dr = [0, 0, -1, 1]
dc = [1, -1, 0, 0]

def is_done(up):
	for key in up.keys():
		cnt = 0
		tmp = key
		while True:
			if up[tmp] == -1:
				break
			tmp = up[tmp]
			cnt += 1
		if cnt == 3:
			return True
	return False

def stack(nr, nc, new):
	top = piece.index([nr, nc])
	while up[top] != -1:
		top = up[top]
	up[top] = new

def pop(r, c, leave):
	top = piece.index([r, c])
	while up[top] != leave:
		top = up[top]
	up[top] = -1

def move_together(nr, nc, bottom):
	tmp = bottom
	while True:
		piece[tmp] = [nr, nc]
		if up[tmp] == -1:
			break
		tmp = up[tmp]

# 흰색인 경우 -> 쌓아주고 위에있는애랑 같이 움직임, 밑에 있는애 고치기
def white(r, c, i, nr, nc):
	if [nr, nc] in piece:
		stack(nr, nc, i)
	move_together(nr, nc, i)
	if [r, c] in piece:
		pop(r, c, i)

# 빨간색인 경우 -> 순서 바꿔주고 쌓음(쌓을 때 i말고 새로운걸로), 밑에 있는애 고치기
def red(r, c, i, nr, nc):
	next = up[i]
	prev = i
	up[i] = -1
	while next != -1:
		tmp = up[next]
		up[next] = prev
		prev = next
		next = tmp
	if [nr, nc] in piece:
		stack(nr, nc, prev)
	move_together(nr, nc, prev)
	if [r, c] in piece:
		pop(r, c, i)

def move():
	for i in range(K):
		r, c= piece[i]
		d = direct[i]
		nr, nc = r+dr[d], c+dc[d]
		# 체스판을 벗어나거나 파란색인 경우 -> 그자리에서 이동방향 반대로
		if nr not in range(N) or nc not in range(N) or board[nr][nc] == 2:
			if d == 0 or d == 2:
				direct[i] = d+1
			else:
				direct[i] = d-1
			nd = direct[i]
			nr, nc = r+dr[nd], c+dc[nd]
			# 움직이려는 곳이 파란색이 아니면 한칸
			if nr in range(N) and nc in range(N) and board[nr][nc] != 2:
				if board[nr][nc] == 0:
					white(r, c, i, nr, nc)
				else:
					red(r, c, i, nr, nc)
		elif board[nr][nc] == 0:
			white(r, c, i, nr, nc)
		else:
			red(r, c, i, nr, nc)
		if is_done(up):
			return True
	return False

N, K = map(int, input().split())
board = []
for _ in range(N):
	board.append(list(map(int, input().split())))
piece = []
direct = []
up = {}
for i in range(K):
	r, c, d = map(int, input().split())
	piece.append([r-1, c-1])
	direct.append(d-1)
	up[i] = -1

turn = 0
while True:
	if is_done(up) or turn > 1000:
		break
	turn += 1
	if move():
		break
print(turn if turn <= 1000 else -1)
