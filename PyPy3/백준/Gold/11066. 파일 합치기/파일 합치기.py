import sys

t = int(sys.stdin.readline())

for _ in range(t):
    size = int(sys.stdin.readline())
    files = [0] + list(map(int, sys.stdin.readline().strip().split()))
    subsum = [0]*(size+1)
    for i in range(1, size+1):
        subsum[i] = subsum[i-1] + files[i] # 누적합

    dp = [[0 for i in range(size+1)] for _ in range(size+1)]

    for i in range(2, size+1):
        for j in range(1, size+2-i):
            dp[j][j+i-1] = min([dp[j][j+k] + dp[j+k+1][j+i-1] for k in range(i-1)]) + subsum[j+i-1] - subsum[j-1]
    print(dp[1][size])