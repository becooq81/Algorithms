n = int(input())
ans = []

for i in range(n):
    nums = list(str(i))
    sum = i
    for num in nums:
        sum += int(num)
    if (sum == n):
        ans.append(i)
if ans:
    print(min(ans))
else:
    print(0)