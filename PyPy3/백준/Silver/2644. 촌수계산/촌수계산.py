from collections import deque
dict = {}
n = int(input())
for i in range(n):
    dict[i] = []
a, b = map(int, input().split())
a -= 1
b -=1
m= int(input())
for _ in range(m):
    x, y = map(int, input().split())
    x -= 1
    y -= 1
    dict[x].append(y)
    dict[y].append(x)
    
def bfs(start):
    queue = deque()
    queue.append(start)
    visited = [0] * n
    visited[start] = 1
    
    while queue:
        x = queue.popleft()
        for i in dict[x]:
            if b == x:
                return visited[x] -1
            if visited[i] == 0:
                visited[i] = visited[x] + 1
                queue.append(i)
    return -1
print(bfs(a))