def solution(n, m, section):
    max = 0
    answer = 0
    for i in range(len(section)):
        if section[i] < max:
            continue
        answer += 1
        max = section[i] + m
    return answer