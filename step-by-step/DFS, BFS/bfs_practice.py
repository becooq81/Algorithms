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

n = int(input())
k = int(input())

graph = [list() for _ in range(n)]
for _ in range(k):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

visited = [0] * n
route = bfs(1)
print(route)