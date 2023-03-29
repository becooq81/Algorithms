import sys
n, c = map(int, sys.stdin.readline().rstrip().split())
houses = []
for i in range(n):
    houses.append(int(sys.stdin.readline()))

houses = sorted(houses)
start, end = 1, max(houses)
while start <= end:
    first = houses[0]
    mid = (start + end)//2
    count = 1
    for x in houses:
        if x >= first + mid:
            first = x
            count += 1
    if count >= c:
        start = mid + 1
    else:
        end = mid - 1
print(start - 1)