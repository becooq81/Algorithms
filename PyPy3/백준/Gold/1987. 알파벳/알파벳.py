import sys
input = sys.stdin.readline
r, c = map(int, input().split())
graph = [list(map(lambda x: ord(x)-65, input())) for _ in range(r)]
visited = [0] * 26

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
ans = 0

visited[graph[0][0]] = 1

def dfs(x, y, tmp):
    global ans
    ans= max(ans, tmp)
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        if nx >= 0 and nx < r and ny < c and ny >= 0 and visited[graph[nx][ny]] == 0:
            visited[graph[nx][ny]] = 1
            dfs(nx, ny, tmp + 1)
            visited[graph[nx][ny]] = 0
dfs(0, 0, 1)
print(ans)