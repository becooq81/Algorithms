n = int(input())

weight = [0]*n
height = [0]*n
rank = [0]*n

for i in range(n):
    weight[i], height[i] = map(int, input().split())

for i in range(n):
    count = 0
    for j in range(n):
        if (weight[j] > weight[i] and height[j] > height[i]):
            count += 1
    rank[i] = count + 1

for r in rank:
    print(r, end=" ")