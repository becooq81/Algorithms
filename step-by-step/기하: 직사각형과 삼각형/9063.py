n = int(input())

x_nums = []
y_nums = []
for _ in range(n):
    x, y = map(int, input().split())
    x_nums.append(x)
    y_nums.append(y)

x_min = min(x_nums)
x_max = max(x_nums)
y_min = min(y_nums)
y_max = max(y_nums)

print((x_max-x_min)*(y_max-y_min))