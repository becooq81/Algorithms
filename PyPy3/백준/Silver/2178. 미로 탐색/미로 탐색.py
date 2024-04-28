def bfs(x, y):
    visited[x][y] = 1
    queue = [(x, y)]
    
    while queue:
        node = queue.pop(0)
        if node[0] == n - 1 and node[1] == m - 1:
            return visited[node[0]][node[1]]  # Return the length of shortest path
        for i in range(4):
            nx = node[0] + dx[i]
            ny = node[1] + dy[i]
            
            if 0 <= nx < n and 0 <= ny < m and matrix[nx][ny] == "1" and visited[nx][ny] == 0:
                visited[nx][ny] = visited[node[0]][node[1]] + 1  # Update distance
                queue.append((nx, ny))

n, m = map(int, input().split())
matrix = [input() for _ in range(n)]
visited = [[0] * m for _ in range(n)]
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

print(bfs(0, 0))
