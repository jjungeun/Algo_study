'''
https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
이상한 피라미드 탐험
'''

def get_depth_range(depth):
    min_value = (depth * (depth -1)) / 2 + 1
    max_value = (depth * (depth + 1)) / 2
    return min_value, max_value

def get_depth(a, b):
    depth = 1
    a_depth = -1
    b_depth = -1
    while True:
        min_value, max_value = map(int, get_depth_range(depth))
        if a in range(min_value, max_value +1):
            a_depth = depth
            a_idx = a - min_value
        if b in range(min_value, max_value +1):
            b_depth = depth
            b_idx = b - min_value
            break
        depth += 1
    return (a, a_idx, a_depth), (b, b_idx, b_depth)

def find_dist(a_info, b_info):
    (a, a_idx, a_depth), (b, b_idx, b_depth) = a_info, b_info
    depth_diff = b_depth - a_depth
    if depth_diff == 0:
        return b - a
    if b_idx in range(a_idx, a_idx + depth_diff + 1):
        return depth_diff
    else:
        if b_idx < a_idx:
            return depth_diff + a_idx - b_idx
        elif b_idx > a_idx + depth_diff:
            return b_idx - a_idx

T = int(input())
for test_case in range(1, T + 1):
    a, b = map(int,input().split())
    a_info, b_info = get_depth(min(a, b), max(a, b))
    print("#{0} {1}".format(test_case, find_dist(a_info, b_info)))
