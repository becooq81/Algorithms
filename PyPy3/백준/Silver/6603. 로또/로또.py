def dfs(start, limit, route, nums):
    if len(route) == 6:
        print(' '.join(map(str, route)))
    for i in range(start, len(nums)):
        route.append(nums[i])
        dfs(i+1, limit, route, nums)
        route.pop()

while True:
    nums = list(map(int, input().split()))
    if nums[0] == 0:
        break
    limit = nums[0]
    nums = nums[1:]
    nums.sort()
    dfs(0, limit, [], nums)
    print()