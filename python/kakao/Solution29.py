origin_cube = {
	'w' : [['w' for _ in range(3)] for _ in range(3)],
	'g' : [['g' for _ in range(3)] for _ in range(3)],
	'r' : [['r' for _ in range(3)] for _ in range(3)],
	'b' : [['b' for _ in range(3)] for _ in range(3)],
	'o' : [['o' for _ in range(3)] for _ in range(3)],
	'y' : [['y' for _ in range(3)] for _ in range(3)],
}

turn_dict = {
	'U' : [['o', 'b', 'r', 'g'], 'w'],
	'D' : [['g', 'r', 'b', 'o'], 'y'],
	'F' : [['w', 'b', 'y', 'g'], 'r'],
	'B' : [['y', 'b', 'w', 'g'], 'o'],
	'L' : [['w', 'r', 'y', 'o'], 'g'],
	'R' : [['y', 'r', 'w', 'o'], 'b'],
}

def turn_face(cube, face, direct):
	turn_cube = cube[face]
	tmp = []
	if direct == '+':
		for col in range(3):
			row_tmp = []
			for row in range(2, -1, -1):
				row_tmp.append(turn_cube[row][col])
			tmp.append(row_tmp)
	else:
		for col in range(2, -1, -1):
			row_tmp = []
			for row in range(3):
				row_tmp.append(turn_cube[row][col])
			tmp.append(row_tmp)
	cube[face] = tmp

def get_col(arr, col):
	ret = []
	for row in range(3):
		ret += arr[row][col]
	return ret

def get_col_rev(arr, col):
	ret = []
	for row in range(2, -1, -1):
		ret += arr[row][col]
	return ret

def set_col(arr, col, new_col):
	for row in range(3):
		arr[row][col] = new_col[row]

def set_col_rev(arr, col, new_col):
	for row in range(3):
		arr[2 - row][col] = new_col[row]

def turn_side(cube, face, sides):
	if face == 'U' or face == 'D':
		row = 0 if face == 'U' else 2
		pre = cube[sides[0]][row]
		for idx in range(1,4):
			side = sides[idx]
			tmp = cube[side][row]
			cube[side][row] = pre
			pre = tmp
		cube[sides[0]][row] = pre
	elif face == 'L':
		col = 0
		pre = get_col(cube[sides[0]], col)
		for idx in range(1, 3):
			side = sides[idx]
			tmp = get_col(cube[side], col)
			set_col(cube[side], col, pre)
			pre = tmp
		tmp = get_col_rev(cube[sides[3]], 2)
		set_col_rev(cube[sides[3]], 2, pre)
		set_col_rev(cube[sides[0]], col, tmp)
	elif face == 'R':
		col = 2
		pre = get_col(cube[sides[0]], col)
		for idx in range(1, 3):
			side = sides[idx]
			tmp = get_col(cube[side], col)
			set_col(cube[side], col, pre)
			pre = tmp
		tmp = get_col_rev(cube[sides[3]], 0)
		set_col_rev(cube[sides[3]], 0, pre)
		set_col_rev(cube[sides[0]], col, tmp)
	elif face == 'F':
		pre = cube[sides[0]][2]

		tmp = get_col(cube[sides[1]], 0)
		set_col(cube[sides[1]], 0, pre)
		pre = tmp

		tmp = cube[sides[2]][0]
		cube[sides[2]][0] = pre
		pre = tmp

		tmp = get_col(cube[sides[3]], 2)
		set_col(cube[sides[3]], 2, pre)
		pre = tmp

		cube[sides[0]][2] = pre
	elif face == 'B':
		pre = cube[sides[0]][2]

		tmp = get_col(cube[sides[1]], 2)
		set_col(cube[sides[1]], 2, pre)
		pre = tmp

		tmp = cube[sides[2]][0]
		cube[sides[2]][0] = pre
		pre = tmp

		tmp = get_col(cube[sides[3]], 0)
		set_col(cube[sides[3]], 0, pre)
		pre = tmp

		cube[sides[0]][2] = pre

def print_w(arr):
	for row in range(3):
		print(''.join(arr[row]))

import copy
N = int(input())
for _ in range(N):
	cases = int(input())
	turn = input().split(' ')
	cube = copy.deepcopy(origin_cube)
	for case in turn:
		face, direct = case
		sides = turn_dict[face][0]
		cube_face = turn_dict[face][1]
		turn_face(cube, cube_face, direct)
		if direct == '-':
			for _ in range(3):
				turn_side(cube, face, sides)
		else:
				turn_side(cube, face, sides)
	print_w(cube['w'])
