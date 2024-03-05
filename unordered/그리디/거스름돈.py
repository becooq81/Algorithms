import sys

ret = int(sys.stdin.readline())
coins = [500, 100, 50, 10]

n = 0
for i in coins:
    n += (ret // i)
    ret %= i

print(n)