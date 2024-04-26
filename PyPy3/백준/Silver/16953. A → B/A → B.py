a, b = map(int, input().split())
visited = {}
def bfs():
    queue = [(a, 1)]
    while queue:
        node, dist = queue.pop(0)
        if node > b:
            continue
        if node == b:
            print(dist)
            break
        queue.append((int(str(node)+"1"), dist+1))
        queue.append((node*2, dist+1))
    else:
        print(-1)
bfs()