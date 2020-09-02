def solution(n, costs):
    answer = 0
    costs = sorted(costs, key=lambda k: k[2])
    bridge = set([costs[0][0]])
    idx = 0
    while len(bridge) < n:
        for i, cost in enumerate(costs):
            s, e, c = cost
            if s in bridge and e in bridge:
                continue
            elif s in bridge or e in bridge:
                bridge.add(s)
                bridge.add(e)
                answer += c
                costs.pop(i)
                break
    return answer
