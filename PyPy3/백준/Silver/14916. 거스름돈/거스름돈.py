change = int(input())
max_fives = int(change / 5)
ans = []
for i in range(max_fives+1):
    if (change - i * 5) % 2 == 0:
        ans.append(i + int((change-i*5)/2))
if len(ans) == 0:
    print(-1)
else:
    print(min(ans))