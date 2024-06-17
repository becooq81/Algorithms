from collections import deque
m, n, h = map(int, input().split())
graph = [[0]*n for _ in range(h)]

visited = [[[0] * m for _ in range(n)] for _ in range(h)]
queue = deque()

dy = [0, 0, 1, -1, 0, 0]
dz = [1, -1, 0, 0, 0, 0]
dx = [0, 0, 0, 0, 1, -1]

all_ripe = True
for i in range(h):
    for j in range(n):
        graph[i][j] = list(map(int, input().split()))
        for k in range(m):
            if graph[i][j][k] == 1:
                queue.append((i, j, k))
                visited[i][j][k] = 1
            if graph[i][j][k] == 0:
                all_ripe = False
if all_ripe:
    print(0)
    exit()


while queue:
    z, y, x = queue.popleft()
    for i in range(6):
        nx = x + dx[i]
        ny = y + dy[i]
        nz = z + dz[i]
        if 0 <= nx < m and 0 <= ny < n and 0 <= nz < h and visited[nz][ny][nx] == 0 and graph[nz][ny][nx] == 0:
            visited[nz][ny][nx] = visited[z][y][x] + 1
            graph[nz][ny][nx] = 1
            queue.append((nz, ny, nx))

max_time = 0
for i in range(h):
    for j in range(n):
        for k in range(m):
            if graph[i][j][k] == 0:
                print(-1)
                exit()
            if visited[i][j][k] > max_time:
                max_time = visited[i][j][k]
print(max_time-1)