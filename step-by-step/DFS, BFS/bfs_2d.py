from collections import deque

def bfs(start_x, start_y, graph):
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    queue = deque([(start_x, start_y)])
    visited = set([(start_x, start_y)])

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < len(graph) and 0 <= ny < len(graph[0]):
                if (nx, ny) not in visited:
                    visited.add((nx, ny))
                    queue.append((nx, ny))
    return -1