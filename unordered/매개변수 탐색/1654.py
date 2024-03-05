k, n = map(int, input().split())
A = []
for i in range(k):
    A.append(int(input()))

start = 1
end = max(A)

while start < end:
    mid = (start + end + 1) // 2
    c = 0
    for i in range(k):
        c += A[i] // mid
    if c >= n:
        start = mid
    else:
        end = mid - 1
print(start)