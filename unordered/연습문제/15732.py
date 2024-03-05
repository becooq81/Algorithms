import sys

n, k, d = map(int, sys.stdin.readline().split())
A = []
B = []
C = []
for _ in range(k):
    a, b, c = map(int, sys.stdin.readline().split())
    A.append(a)
    B.append(b)
    C.append(c)

start, end = 1, n
while start < end:
    mid = (start + end)//2

    arr = [0] * mid
    count = 0
    for i in range(k):
        limit = min(mid, B[i])
        if limit > A[i]:
            count += (limit - A[i])//C[i] + 1
        elif limit == A[i]:
            count += 1
    if count >= d:
        end = mid
    else:
        start = mid + 1

print(start)