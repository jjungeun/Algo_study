def solution(gems):
    answer = [0, len(gems)]
    gem_dict = {gems[0]: 1}
    gem_kind = len(set(gems))
    left, right = 0, 0
    while left < len(gems) and right < len(gems):
        if len(gem_dict) < gem_kind:
            right += 1
            if right == len(gems):
                break
            if gems[right] in gem_dict.keys():
                gem_dict[gems[right]] += 1
            else:
                gem_dict[gems[right]] = 1
        else:
            if right - left < answer[1] - answer[0]:
                answer = [left+1, right+1]
            if gem_dict[gems[left]] == 1:
                del gem_dict[gems[left]]
            else:
                gem_dict[gems[left]] -= 1
            left += 1
    return answer
