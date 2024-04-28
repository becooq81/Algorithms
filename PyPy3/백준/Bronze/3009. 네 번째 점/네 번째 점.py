x_nums = []
y_nums = []
for _ in range(3):
    x, y = map(int, input().split())
    x_nums.append(x)
    y_nums.append(y)

x_freq = {}
y_freq = {}
for x in x_nums:
    if x in x_freq:
        x_freq[x] += 1
    else:
        x_freq[x] = 1
for y in y_nums:
    if y in y_freq:
        y_freq[y] += 1
    else:
        y_freq[y] = 1

x_ans = 0
for key, value in x_freq.items():
    if value % 2 != 0:
        x_ans = key
y_ans = 0
for key, value in y_freq.items():
    if value % 2 != 0:
        y_ans = key

print(x_ans, y_ans)