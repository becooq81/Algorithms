import sys
input = sys.stdin.readline

n = input()
t_arr = []
p_arr = []
for i in range(n):
    t, p = map(int, input().split())
    t_arr.append(t)
    p_arr.append(p)