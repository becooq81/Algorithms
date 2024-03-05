import sys

input = sys.stdin.readline

n = int(input())
count = 0
start = 665

while count <= n:
    if "666" in str(start):
        count += 1
    if count == n:
        print(start)
        break
    start += 1