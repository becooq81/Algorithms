import sys

a, b, c = map(int, sys.stdin.readline().split())

def same(a, b, c):
    if a == b == c:
        return 3, a
    elif a == b:
        return 2, a
    elif a == c:
        return 2, a
    elif b == c:
        return 2, b
    else:
        return 1, max(a, b, c)

n, val = same(a, b, c)
if (n==1):
    print(100*val)
elif (n==2):
    print(1000+100*val)
else:
    print(10000+1000*val)