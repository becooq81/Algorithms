n, s = map(int, input().split())
nums = list(map(int, input().split()))

ans = 0
route = []

def dfs(start):
    global ans
    if sum(route) == s and len(route) > 0:
        ans += 1
    for i in range(start, n):
        route.append(nums[i])
        dfs(i+1)
        route.pop()

dfs(0)
print(ans)
