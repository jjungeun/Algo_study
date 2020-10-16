import sys
sys.stdin = open("input.txt", "r")

import copy
def turn_face(face):
	new_face = []
	for c in range(3):
		row = []
		for r in range(2, -1, -1):
			row.append(face[r][c])
		new_face.append(row)
	return new_face

def copy_source(source, sidx, is_srow):
	new_dest = [0 for _ in range(3)]
	if is_srow:
		new_dest = copy.deepcopy(source[sidx])
	else:
		for r in range(3):
			new_dest[r] = source[r][sidx]
	return new_dest

def turn_side(dest, new_dest, didx, is_drow, is_reverse):
	if not is_reverse:
		if is_drow:
			dest[didx] = copy.deepcopy(new_dest)
		else:
			for r in range(3):
				dest[r][didx] = new_dest[r]
	else:
		if is_drow:
			dest[didx] = copy.deepcopy(new_dest[::-1])
		else:
			for r in range(3):
				dest[r][didx] = new_dest[2 - r]

def cubing(face):
	global up
	global down
	global front
	global back
	global left
	global right
	if face == 'U':
		up = turn_face(up)
		tmp = copy_source(front, 0, True)
		source = copy_source(right, 0, True)
		turn_side(front, source, 0, True, False)
		source = copy_source(back, 0, True)
		turn_side(right, source, 0, True, False)
		source = copy_source(left, 0, True)
		turn_side(back, source, 0, True, False)
		turn_side(left, tmp, 0, True, False)
	elif face == 'D':
		down = turn_face(down)
		tmp = copy_source(front, 2, True)
		source = copy_source(left, 2, True)
		turn_side(front, source, 2, True, False)
		source = copy_source(back, 2, True)
		turn_side(left, source, 2, True, False)
		source = copy_source(right, 2, True)
		turn_side(back, source, 2, True, False)
		turn_side(right, tmp, 2, True, False)
	elif face == 'F':
		front = turn_face(front)
		tmp = copy_source(up, 2, True)
		source = copy_source(left, 2, False)
		turn_side(up, source, 2, True, True)
		source = copy_source(down, 0, True)
		turn_side(left, source, 2, False, False)
		source = copy_source(right, 0, False)
		turn_side(down, source, 0, True, True)
		turn_side(right, tmp, 0, False, False)
	elif face == 'B':
		back = turn_face(back)
		tmp = copy_source(up, 0, True)
		source = copy_source(right, 2, False)
		turn_side(up, source, 0, True, False)
		source = copy_source(down, 2, True)
		turn_side(right, source, 2, False, True)
		source = copy_source(left,  0, False)
		turn_side(down, source, 2, True, False)
		turn_side(left, tmp, 0, False, True)
	elif face == 'L':
		left = turn_face(left)
		tmp = copy_source(up, 0, False)
		source = copy_source(back, 2, False)
		turn_side(up, source, 0, False, True)
		source = copy_source(down, 0, False)
		turn_side(back, source, 2, False, True)
		source = copy_source(front, 0, False)
		turn_side(down, source, 0, False, False)
		turn_side(front, tmp, 0, False, False)
	elif face == 'R':
		right = turn_face(right)
		tmp = copy_source(front, 2, False)
		source = copy_source(down, 2, False)
		turn_side(front, source, 2, False, False)
		source = copy_source(back, 0, False)
		turn_side(down, source, 2, False, True)
		source = copy_source(up, 2, False)
		turn_side(back, source, 0, False, True)
		turn_side(up, tmp, 2, False, False)


T = int(input())
for _ in range(T):
	up = [['w' for _ in range(3)] for _ in range(3)]
	down = [['y' for _ in range(3)] for _ in range(3)]
	front = [['r' for _ in range(3)] for _ in range(3)]
	back = [['o' for _ in range(3)] for _ in range(3)]
	left = [['g' for _ in range(3)] for _ in range(3)]
	right = [['b' for _ in range(3)] for _ in range(3)]
	n = int(input())
	turn = list(input().split())
	for info in turn:
		# 시계방향으로 한번
		if info[1] == '+':
			cubing(info[0])
		# 반시계면 시계방향으로 세번
		else:
			cubing(info[0])
			cubing(info[0])
			cubing(info[0])
	for r in range(3):
		print(''.join(up[r]))

