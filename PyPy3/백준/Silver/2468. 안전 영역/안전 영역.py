import copy

def bfs(height, start_x, start_y):
    # mark visited as 0 since height is value of 1~100
    graph[start_x][start_y] = 0
    queue = [(start_x, start_y)]
    count = 1
    while queue:
        x, y = queue.pop(0)
        
        for i in range(4):
            nx = dx[i] + x
            ny = dy[i] + y  
            if 0 <= nx < N and 0 <= ny < N and graph[nx][ny] > height:
                 graph[nx][ny] = 0
                 queue.append((nx, ny))
                 count += 1
    return count
                 
N = int(input())
map = []
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
for _ in range(N):
    nums_str = input().split()
    map.append([int(num) for num in nums_str])

graph = []
regions = [1]
for height in range(1, 101):
    graph = copy.deepcopy(map)
    region_count = 0
    for i in range(N):
        for j in range(N):
            if graph[i][j] > height:
                tmp = bfs(height, i, j)
                if tmp > 0:
                    region_count += 1
    regions.append(region_count)
print(max(regions))