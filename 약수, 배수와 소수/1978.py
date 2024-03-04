n = int(input())
nums = list(map(int, input().split()))
count = 0

for num in nums:
    if num == 0 or num == 1:
        continue
    elif num == 2:
        count += 1
    else:
        is_ans = True
        for i in range(2, num):
            if num % i == 0:
                is_ans = False
                break
        if is_ans:
            count += 1
print(count)