import sys
sys.stdin = open("input.txt", "r")

def get_available(top):
	start_pos = top
	cnt = N//4
	for v in range(4):
		new_num = ''
		i = start_pos
		for _ in range(cnt):
			new_num += num[i]
			i = (i+1) % N
		num_case.add(new_num)
		start_pos = (start_pos+cnt) % N

number = ['0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F']
def ten_base(n):
	ten_n = 0
	mul = 1
	for i in range(N//4-1, -1, -1):
		ten_n += int(number.index(n[i])) * mul
		mul *= 16
	return ten_n

T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T+1):
	N, K = map(int, input().split())
	num = []
	for c in input().split()[0]:
		num.append(c)
	num_case = set()
	top = 0
	for _ in range(N//4):
		get_available(top)
		top = (top - 1) % N
	ten_nums = []
	for n in num_case:
		ten_n = ten_base(n)
		ten_nums.append(ten_n)
	print("#%d %d" % (test_case, sorted(ten_nums, reverse=True)[K-1]))
