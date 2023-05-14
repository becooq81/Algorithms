import sys

n = int(sys.stdin.readline())

time = [0]*n
price = [0]*n
for i in range(n):
    time[i], price[i] = map(int, sys.stdin.readline().split())

# dp = [0]*(n+1)
# for i in range(n):
#     tmp_arr = list()
#     for j in range(i):
#         k = j
#         tmp = dp[k - 1]
#         while k <= i:
#             if k + time[k] > i + 1:
#                 k += 1
#             else:
#                 tmp += price[k]
#                 k += time[k]
#         tmp_arr.append(tmp)
#         dp[i] = max(tmp_arr)
# print(max(dp))

dp = [0]*(n+1)

tmp = 0
for i in range(n):
    tmp = max(tmp, dp[i])
    if i + time[i] > n:
        pass
    else:
        dp[i+time[i]] = max(tmp+price[i], dp[i+time[i]])
print(max(dp))