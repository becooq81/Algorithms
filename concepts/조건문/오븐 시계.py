import sys

a, b = map(int, sys.stdin.readline().split())
c = int(sys.stdin.readline())

if b + c >= 60:
    n = (b + c) // 60
    a += n
    b = b + c - 60 * n
    if a >= 24:
        a -= 24
else:
    b += c

print(a, b)