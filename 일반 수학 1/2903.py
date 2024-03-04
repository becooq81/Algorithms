n = int(input())

ans = 2
for i in range(n):
    ans += 2**i
print(ans**2)