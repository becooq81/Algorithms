import sys

n, m = map(int, sys.stdin.readline().split())
data = []
for i in range(n):
    row = list(map(int, sys.stdin.readline().split()))
    data.append(min(row))
ans = max(data)
print(ans)

