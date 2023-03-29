import sys

n, m = map(int, sys.stdin.readline().split())
trees = list(map(int, sys.stdin.readline().split()))

start, end = 0, max(trees)

while (start < end):
    mid = (start + end) // 2
    sum = 0
    for i in range(n):
        if trees[i] > mid:
            sum += (trees[i] - mid)
        if sum > m:
            break
    if sum >= m:
        start = mid + 1
    else:
        end = mid
print(start - 1)