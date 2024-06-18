n = int(input())
loss = list(map(int, input().split()))

days = round(n/2)
if n % 2 == 1:
    loss.append(0)
loss.sort()
ans = []
for i in range(days):
    ans.append(loss[i] + loss[-1-i])
print(max(ans))