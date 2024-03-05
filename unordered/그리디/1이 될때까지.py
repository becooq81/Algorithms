import sys

n, k = map(int, sys.stdin.readline().split())

c = 0
while n > 1:
    c += 1
    if (n % k == 0):
        n /= k
    else:
        n -= 1
print(c)