from collections import deque

def bfs(start_x, start_y, coordinates, festival_x, festival_y):
    queue = deque([(start_x, start_y)])
    visited = set((start_x, start_y))
    
    while queue:
        curr_x, curr_y = queue.popleft()
        
        if abs(curr_x - festival_x) + abs(curr_y - festival_y) <= 1000:
            return "happy"
        
        for x, y in coordinates:
            if (x, y) not in visited:
                if abs(curr_x - x) + abs(curr_y - y) <= 1000:
                    queue.append((x, y))
                    visited.add((x, y))
                    
    return "sad"

t = int(input())
results = []

for _ in range(t):
    n = int(input())
    house_x, house_y = map(int, input().split())
    coordinates = []
    for _ in range(n):
        coordinates.append(tuple(map(int, input().split())))
    festival_x, festival_y = map(int, input().split())
    
    result = bfs(house_x, house_y, coordinates, festival_x, festival_y)
    results.append(result)

for result in results:
    print(result)
