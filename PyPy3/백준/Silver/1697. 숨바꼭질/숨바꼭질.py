def bfs(start):
    queue = [start]
    while queue:
        node = queue.pop(0)
        
        if node == K:
            return arr[node]
        
        for i in (node -1, node +1, 2* node):
           if 0 <= i <= 100000 and arr[i] == 0:
               queue.append(i)
               arr[i] = arr[node] + 1

N, K = map(int, input().split())
arr = [0] * 100001
print(bfs(N))