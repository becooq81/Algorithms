n, m = map(int, input().split())
nums = list(map(int, input().split()))
nums.sort()

route = []
visited = [0]*n
def dfs():
    if len(route) == m:
        print(' '.join(map(str, route)))
        return
    for i in range(n):
        if visited[i] == 0 and (len(route) == 0 or route[-1] < nums[i]):
            route.append(nums[i])
            visited[i] += 1
            dfs()
            route.pop()
            visited[i] -=1
dfs()