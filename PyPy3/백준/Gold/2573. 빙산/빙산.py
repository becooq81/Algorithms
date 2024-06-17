from collections import deque
n, m = map(int, input().split())
graph = [0] * n

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for i in range(n):
    graph[i] = list(map(int, input().split()))

def update_yearly(graph, n, m):
    temp_graph = [row[:] for row in graph]
    for i in range(n):
        for j in range(m):
            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]
                if 0<=nx<m and 0<= ny < n and graph[ny][nx] == 0:
                    temp_graph[i][j] -= 1
            if temp_graph[i][j] < 0:
                temp_graph[i][j] = 0
    return temp_graph

visited = [[0]*m for _ in range(n)]

def bfs(start_x, start_y):
    queue = deque()
    queue.append((start_x, start_y))
    visited[start_y][start_x] = 1
    
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            if 0 <= nx < m and 0 <= ny < n and graph[ny][nx] > 0 and visited[ny][nx] == 0:
                queue.append((nx, ny))
                visited[ny][nx] = 1
year = 0
while True:
    count = 0
    visited = [[0]*m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if visited[i][j] == 0 and graph[i][j] > 0:
                bfs(j, i)
                count += 1
    if count >= 2:
        print(year)
        break
    graph = update_yearly(graph, n, m)
    year += 1
    if count == 0:
        print(0)
        break