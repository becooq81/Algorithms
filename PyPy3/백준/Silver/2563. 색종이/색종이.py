from itertools import chain
n = int(input())
coordinates = [list(map(int, input().split())) for _ in range(n)]

map = [[False for _ in range(100)] for _ in range(100)]
for x, y in coordinates:
    for i in range(x, x+10):
        for j in range(y, y+10):
            map[i][j] = True

print(sum(list(chain.from_iterable(map))))