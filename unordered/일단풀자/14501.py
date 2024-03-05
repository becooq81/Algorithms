import sys
input = sys.stdin.readline

n = int(input())
t_arr = []
p_arr = []
for i in range(n):
    t, p = map(int, input().split())
    t_arr.append(t)
    p_arr.append(p)

dp = [0 for i in range(n+1)]
for i in range(n):
    for j in range(i + t_arr[i], n+1):
        if dp[i] + p_arr[i] > dp[j]:
            dp[j] = dp[i] + p_arr[i]

print(dp[j])