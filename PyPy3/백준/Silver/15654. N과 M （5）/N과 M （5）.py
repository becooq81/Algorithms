n, m = map(int, input().split())
nums = list(map(int, input().split()))

route = []
visited = [0] * 100001
nums.sort()
def dfs():
    if len(route) == m:
        print(' '.join(map(str, route)))
        return
    for i in range(len(nums)):
        if visited[nums[i]] == 0:
            route.append(nums[i])
            visited[nums[i]] += 1
            dfs()
            route.pop()
            visited[nums[i]] -= 1
dfs()