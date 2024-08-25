A, P = map(int, input().split())
visited = {}

series = []

num = A
while True:
    series.append(num)
    if num not in visited:
        visited[num] = 1
    else:
        idx = series.index(num)
        print(len(series[:idx]))
        break
    tmp = 0
    for i in range(len(str(num))):
        tmp += int(str(num)[i])**P
    num = tmp
