n = int(input())
if n == 1:
    pass
else:
    res = n
    start = 2
    while res > 1:
        for i in range(start, n+1):
            if (res % i == 0):
                res //= i
                print(i)
                start = i
                break
        if res == 1:
            break
               