import sys
import numpy as np

n, m = map(int, sys.stdin.readline().split())
h = list(map(int, sys.stdin.readline().split()))

for i in range(max(h), 0, -1):
    left = np.array(h)-i
    left[left<0] = 0
    s = np.sum(left)
    if (s >= m):
        print(i)
        break