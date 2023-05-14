import sys

n = int(sys.stdin.readline())

dp = [0] * (n+1)

ans = 0
tmp = 0


dp[1] = 0

for i in range(2, n+1):
    tmp_arr = list()
    if i % 3 == 0:
        tmp_arr.append(dp[i//3] + 1)
    if i % 2 == 0:
        tmp_arr.append(dp[i//2] + 1)
    tmp_arr.append(dp[i-1] + 1)
    dp[i] = min(tmp_arr)
print(dp[n])