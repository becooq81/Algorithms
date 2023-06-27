import sys

n, m, k = map(int, sys.stdin.readline().split())
ints = list(map(int, sys.stdin.readline().split()))



ints.sort()

biggest = ints[n-1]
second_biggest = ints[n-2]

""" 
s = 0
c = 0
for i in range(m):
    if c >= k:
        c = 0
        s += second_biggest
    else:
        c += 1
        s += biggest 
"""
# c는 가장 큰 수가 등장하는 횟수
c = int(m / (k + 1)) * k # 가장 큰 수를 k번 + 두번째 수 1번의 배열 횟수에 k를 곱하면 가장 큰 수 등장 횟수 파악 가능
c += m % (k + 1) #남은 것은 가장 큰 수로 마저 더한다

s = c * biggest + (m - c)*second_biggest

print(s)