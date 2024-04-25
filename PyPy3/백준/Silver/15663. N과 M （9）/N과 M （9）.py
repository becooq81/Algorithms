n, m = map(int, input().split())
nums = list(map(int, input().split()))

route = []
visited = [0] * 100001

nums.sort()
def dfs(cnt):
    if len(route) == m:
        print(' '.join(map(str, route)))
        return
    prev = 0
    for i in range(len(nums)):
        if visited[i] == 0 and prev != nums[i]:
            route.append(nums[i])
            visited[i] +=1
            prev = route[cnt]
            dfs(cnt+1)
            route.pop()
            visited[i] -= 1
dfs(0)