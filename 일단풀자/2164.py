import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
deq = deque(range(1, n+1))

sol = 1
while len(deq) > 1:
    deq.popleft()
    deq.append(deq.popleft())
    sol = deq[0]
print(sol)