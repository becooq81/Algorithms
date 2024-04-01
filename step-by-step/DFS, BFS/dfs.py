def dfs(start):
    visited[start] = 1
    route.append(start)
    for i in graph[start]:
        if visited[i] == 0:
            dfs(i)

n = int(input())
k = int(input())
graph = [list() for _ in range(n)]

for _ in range(k):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

for i in range(n):
    graph[i].sort()
    
visited = [0] * n
route = []
dfs(1)
print(route)
