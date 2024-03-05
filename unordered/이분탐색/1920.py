import sys
from bisect import bisect_left

n = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
B = list(map(int, sys.stdin.readline().split()))

A = sorted(A)

for i in range(m):
    index = bisect_left(A, B[i])
    if index >= len(A):
        print(0)
    elif A[index]==B[i]:
        print(1)
    else:
        print(0)