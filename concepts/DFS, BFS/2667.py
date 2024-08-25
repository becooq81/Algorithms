def bfs(start_x, start_y):
    graph[start_x][start_y] = "0"
    queue = [(start_x, start_y)]
    count = 1
    
    while queue:
        x, y = queue.pop(0)
        
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y
            
            if 0 <= nx < N and 0 <= ny < N and graph[nx][ny] == "1":
                graph[nx][ny] = "0"
                count += 1
                queue.append((nx, ny))
    return count

N = int(input())
graph = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for _ in range(N):
    graph.append(list(input()))
counts = []
for i in range(N):
    for j in range(N):
        if graph[i][j] == "1":
            counts.append(bfs(i, j))
print(len(counts))
counts.sort()
for count in counts:
    print(count)