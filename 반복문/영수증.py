import sys

x = int(sys.stdin.readline())
n = int(sys.stdin.readline())
sum = 0
for i in range(n):
    price, count = map(int, sys.stdin.readline().split())
    sum += price*count
if (sum == x):
    print("Yes")
else:
    print("No")