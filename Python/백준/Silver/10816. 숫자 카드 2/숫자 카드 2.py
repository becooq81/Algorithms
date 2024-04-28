from bisect import bisect_left, bisect_right

n = int(input())
A = list(map(int, input().split()))
m = int(input())
B = list(map(int, input().split()))

A = sorted(A)

for i in range(m):
    left = bisect_left(A, B[i])
    right = bisect_right(A, B[i])
    print(right - left, end=" ")