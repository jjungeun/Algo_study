def check_over(rocks, distance, mid, n):
    remove_cnt = 0
    prev = 0
    for i in range(len(rocks)):
        if rocks[i] - prev < mid:
            remove_cnt += 1
        else:
            prev = rocks[i]
    if distance - prev < mid:
        remove_cnt += 1
    return True if remove_cnt > n else False

def solution(distance, rocks, n):
    answer = 0
    rocks = sorted(rocks)

    left = 1
    right = distance

    while left <= right:
        mid = (left + right) // 2
        if check_over(rocks, distance, mid, n):
            right = mid - 1
        else:
            left = mid + 1
            answer = mid if answer < mid else answer
    return answer
