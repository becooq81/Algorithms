import sys

n, m, k = map(int, sys.stdin.readline().split())
numbers = list(map(int, sys.stdin.readline().split()))
numbers.sort()

biggest = numbers[-1]
second = numbers[-2]

count = k * (m // (k + 1)) + (m % (k+1))

sum = (biggest * count) + (second * (m - count))
print(sum)