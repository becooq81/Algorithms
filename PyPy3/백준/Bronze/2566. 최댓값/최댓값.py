nums = [list(map(int, input().split())) for _ in range(9)]

max = 0
max_x = 1
max_y = 1
for i in range(len(nums)):
    for j in range(len(nums[0])):
        if nums[i][j] > max:
            max = nums[i][j]
            max_x = i+1
            max_y = j+1
print(max)
print(max_x, max_y)