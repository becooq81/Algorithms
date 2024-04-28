n, k = map(int, input().split())

count = 0
num = 1
while count < k:
    if n % num == 0:
        count += 1
    if count == k:
        print(num)
        break
    num += 1
    if num > n:
        print(0)
        break
