from collections import deque
f, s, g, u, d = map(int, input().split())
s -= 1
g -= 1
visited = [0]*f
dn = [u, -d]
def bfs(start):
    queue = deque()
    queue.append(start)
    visited[start] = 1
    
    while queue:
        x = queue.popleft()
        
        if x == g:
            print(visited[x]-1)
            exit()
        
        for i in range(2):
            nx = x + dn[i]
            if 0 <= nx < f and visited[nx] == 0:
                visited[nx] = visited[x] + 1
                #print(f"{nx}: {visited[nx]}")
                queue.append(nx)
bfs(s)
print("use the stairs")