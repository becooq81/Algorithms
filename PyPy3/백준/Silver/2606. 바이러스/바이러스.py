from collections import deque

n = int(input()) # num of computers
k = int(input()) # num of connected pairs

graph = [[0]*n for _ in range(n)]
for _ in range(k):
    x, y = map(int, input().split())
    x -= 1
    y -= 1
    graph[x][y] = 1
    graph[y][x] = 1

queue = deque()
visited = [0]*n
count = 0
def dfs(start):
    global count
    visited[start] = 1
    for i in range(n):
        if graph[start][i] != 0 and visited[i] == 0:
            visited[i] = 1
            count += 1
            dfs(i)
    return count

print(dfs(0))