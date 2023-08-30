import sys
from queue import PriorityQueue

n, k = map(int, sys.stdin.readline().split())
pq = PriorityQueue()
bags = []
for i in range(n):
    w, v = map(int, sys.stdin.readline().split())
for j in range(k):
    bags.append(int(sys.stdin.readline()))
bags.sort()


s = 0

for i in range(k):
    tmp = PriorityQueue()
    while (bags[k] >= pqa)
    s += tmp.get()
print(-s)