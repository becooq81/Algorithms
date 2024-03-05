import sys

n, m = map(int, input().split())
lectures = list(map(int, sys.stdin.readline().split()))

ans = 0
start, end = max(lectures), sum(lectures)

while start <= end:
    mid = (start + end) // 2
    count, hours = 1, 0
    for i in range(n):
        if hours + lectures[i] > mid:
            count += 1
            hours = lectures[i]
        else:
            hours += lectures[i]
    if (count > m):
        start = mid + 1
    else:
        end = mid - 1
        ans = mid
print(ans)
