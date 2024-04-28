from collections import deque
import sys

input = sys.stdin.readline

n, p = map(int, input().split())
play = [[0] for _ in range(6)]
count = 0
for i in range(n):
    line, pret = map(int, input().split())
    line -= 1

    while play[line][-1] > pret:
        play[line].pop()
        count += 1
    if play[line][-1] == pret:
        continue

    play[line].append(pret)
    count += 1



print(count)