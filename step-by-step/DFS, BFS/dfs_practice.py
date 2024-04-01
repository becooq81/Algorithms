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

route = []
visited = [0] * n
dfs(1)
print(route)