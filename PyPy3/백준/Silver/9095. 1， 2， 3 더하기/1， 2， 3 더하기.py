import sys

n = int(sys.stdin.readline())
arr = list()
for i in range(n):
    arr.append(int(sys.stdin.readline()))

m = max(arr)

dp = [0]*(m+1)
dp[0] = 0
dp[1] = 1
dp[2] = 2
dp[3] = 4

for i in range(4, m+1):
    dp[i] = dp[i-1]
    dp[i] += dp[i-2]
    dp[i] += dp[i-3]

for i in range(n):
    print(dp[arr[i]])