n, m = map(int, input().split())
nums = list(map(int, input().split()))

route = []
nums.sort()
visited = [0] * 100001
def dfs():
    if len(route) == m:
        print(' '.join(map(str, route)))
        return
    for i in range(len(nums)):
        if visited[nums[i]] <= m and (len(route) == 0 or route[-1] <= nums[i]):
            route.append(nums[i])
            visited[nums[i]] += 1
            dfs()
            route.pop()
            visited[nums[i]] -= 1
dfs()