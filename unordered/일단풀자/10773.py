import sys
from collections import deque
input = sys.stdin.readline

k = int(input())
nums = deque()
for i in range(k):
    n = int(input())
    if n == 0:
        nums.pop()
    else:
        nums.append(n)
print(sum(nums))