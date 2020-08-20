import sys
sys.setrecursionlimit(10**6)

def avail_room(room, book_dict):
	if room not in book_dict.keys():
		book_dict[room] = room+1
		return room
	empty = avail_room(book_dict[room], book_dict)
	book_dict[room] = empty+1
	return empty

def solution(k, room_number):
	answer = []
	book_dict = {}
	for room in room_number:
		room = avail_room(room, book_dict)
		answer.append(room)
	return answer

print(solution(10, [1,3,4,1,3,1]))
