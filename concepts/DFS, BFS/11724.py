from collections import deque
def bfs(start):
    visited[start] = 1
    queue = deque()
    queue.append(start)
    count = 0
    
    while queue:
        node = queue.popleft()
        
        for i in graph[node]:
            if visited[i] == 0:
                visited[i] = 1
                queue.append(i)
                count += 1
    return count

N, M = map(int, input().split())
N += 1
graph = [list() for _ in range(N)]
for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)
visited = [0] * N
 
cntcmpt = 0
for i in range(1, N):
    if visited[i] == 0:
        tmp = bfs(i)
        cntcmpt += 1
            
print(cntcmpt)
