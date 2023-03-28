import sys

h, m = map(int, sys.stdin.readline().split())
if m - 45<0:
    h -= 1
    m = m + 15
    if h < 0:
        h = 23
else:
    m -= 45
print(h, m)