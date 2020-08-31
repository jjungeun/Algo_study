import copy
def is_all_connected(bridge, n):
    node = set()
    queue = copy.deepcopy(bridge.get(0))
    cnt = 0
    while cnt <= n * (n-1):
        if len(queue) > 0:
            num = queue.pop(0)
            queue += bridge.get(num)
            node.add(num)
            if len(node) == n:
                return True
        cnt += 1
    return False

def is_connected(bridge, n, start, end):
    node = set()
    queue = copy.deepcopy(bridge.get(start))
    cnt = 0
    while cnt <= n * (n-1):
        if len(queue) > 0:
            num = queue.pop(0)
            queue += bridge.get(num)
            node.add(num)
            if end in node:
                return True
        cnt += 1
    return False

def solution(n, costs):
    answer = 0
    costs = sorted(costs, key=lambda k: k[2])
    bridge = {}
    idx = 0
    while n > 1:
        if len(bridge) == n and is_all_connected(bridge, n):
            break
        start, end, cost = costs[idx]
        if start not in bridge.keys() or end not in bridge.keys() or not is_connected(bridge, n, start, end):
            if start not in bridge.keys():
                bridge[start] = [end]
            else:
                bridge[start].append(end)
            if end not in bridge.keys():
                bridge[end] = [start]
            else:
                bridge[end].append(start)
            answer += cost
        idx += 1
    return answer
