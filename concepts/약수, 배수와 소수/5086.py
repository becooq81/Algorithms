nums = []

while True:
    a, b = map(int, input().split())
    if (a == 0 and b == 0):
        break
    else:
        nums.append([a,b])

for x, y in nums:
    if (y % x == 0):
        print("factor")
    elif (x % y == 0):
        print("multiple")
    else:
        print("neither")  