def dfs(start):
    visited[start] = 1
    route.append(start)
    for i in graph[start]:
        if visited[i] == 0:
            dfs(i)

def bfs(start):
    visited[start] = 1
    queue = [start]
    route = [start]
    
    while queue:
        node = queue.pop(0)
        for neighbor in graph[node]:
            if visited[neighbor] == 0:
                visited[neighbor] = 1
                route.append(neighbor)
                queue.append(neighbor)
    
    return route

n, m, v = map(int, input().split())
graph = [list() for _ in range(n+1)]
for _ in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

for i in range(n+1):
    graph[i].sort()

visited = [0] * (n+1)
route = []
dfs(v)
print(*route)

visited = [0] * (n+1)
route = bfs(v)
print(*route)