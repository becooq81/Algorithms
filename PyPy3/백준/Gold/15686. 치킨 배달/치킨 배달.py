n, m = map(int, input().split())
graph = []
for _ in range(n):
    tmp = list(map(int, input().split()))
    graph.append(tmp)

houses = []
rests = []

for i in range(n):
    for j in range(n):
        if graph[i][j] == 2:
            rests.append((i, j))
        elif graph[i][j] == 1:
            houses.append((i, j))
routes = []
tmp = []

def dfs():
    global curr
    if len(tmp) == m:
        routes.append(tmp[:])
        return
    for i, j in rests:
        if (i, j) not in tmp and (len(tmp) == 0 or tmp[-1][0] < i or (tmp[-1][0] == i and tmp[-1][1] < j)):
            tmp.append((i, j))
            dfs()
            tmp.pop()

dfs()

ans = float('inf')  # Initialize ans with infinity
for i in range(len(routes)):
    total_distance = 0
    for house_x, house_y in houses:
        min_dist = float('inf')  # Initialize min_dist with infinity
        for rest_x, rest_y in routes[i]:
            dist = abs(house_x - rest_x) + abs(house_y - rest_y)
            min_dist = min(min_dist, dist)
        total_distance += min_dist
    ans = min(ans, total_distance) 
print(ans)