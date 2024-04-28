import sys
from bisect import bisect_left

n = int(input())
X = list(map(int, sys.stdin.readline().rstrip().split()))

arr = sorted(list(set(X)))
result = [0]*n

for i in range(n):
    result[i] = bisect_left(arr, X[i])
print(*result)