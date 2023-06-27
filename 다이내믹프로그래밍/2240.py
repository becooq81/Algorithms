import sys

t, w = map(int, sys.stdin.readline().split())
plums = []
for _ in range(t):
    plum = int(sys.stdin.readline())
    plums.append(plum)

dp = [[0]*(w+1) for _ in range(t)]
for i in range(t):
    for j in range(w+1):
        if j == 0:
            if plums[i] == 1:
                dp[i][0] = dp[i-1][0] + 1
            else:
                dp[i][0] = dp[i-1][0]
        else:
            if plums[i] == 1 and j % 2 == 0:
                dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + 1
            elif plums[i] == 2 and j % 2 == 1:
                dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + 1
            else:
                dp[i][j] = max(dp[i-1][j-1], dp[i-1][j])

print(max(dp[-1]))

