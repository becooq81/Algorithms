import sys

n, k = map(int, sys.stdin.readline().split())

weights = []
values = []
for _ in range(n):
    weight, value = map(int, sys.stdin.readline().split())
    weights.append(weight)
    values.append(value)

dp=[[0]*(100001) for _ in range(101)]

for i in range(n):
    for j in range(k+1):
        if weights[i] > j:
            dp[i+1][j] = dp[i][j]
        else:
            dp[i+1][j] = max(dp[i][j], dp[i][j-weights[i]]+values[i])
print(max(dp[n]))
