m = int(input())
n = int(input())


if m % 2 == 0:
    start = m + 1
else:
    start = m

sum = 0
ans = []
for num in range(start, n+1):
    is_ans = True
    if (num == 1):
        is_ans = False
    else: 
        for i in range(2, int(num**0.5)+2):
            if num % i == 0:
                is_ans = False
                break
    if is_ans:
        sum += num
        if len(ans) == 0:
            ans.append(num)

if 2 in range(m, n+1):
    sum += 2
    ans = [2]

if (sum == 0):
    print(-1)
else:
    print(sum)
    print(*ans)