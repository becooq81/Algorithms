import sys

n, atk = map(int, sys.stdin.readline().split())
t_list = []
a_list = []
h_list = []

for i in range(n):
    t, a, h = map(int, sys.stdin.readline().split())
    t_list.append(t)
    a_list.append(a)
    h_list.append(h)

start, end = 1, 10000000000000000000
while start < end:
    mid = (start + end)//2

    tmp_atk = atk
    tmp_h_list = h_list.copy()
    tmp_user_h = mid

    for i in range(n):
        if t_list[i] == 1:

            if tmp_h_list[i] % tmp_atk == 0:
                q_mon = tmp_h_list[i] // tmp_atk
            else:
                q_mon = tmp_h_list[i] // tmp_atk + 1
            if tmp_user_h % a_list[i] == 0:
                q_user = tmp_user_h // a_list[i] #유저 생존 횟수
            else:
                q_user = tmp_user_h // a_list[i] + 1
            if q_user >= q_mon:
                tmp_user_h -= (q_mon-1)*a_list[i]
            else:
                tmp_user_h = -1
        elif t_list[i] == 2:
            tmp_atk += a_list[i]
            tmp_user_h += h_list[i]
            if tmp_user_h > mid:
                tmp_user_h = mid
        if tmp_user_h <= 0:
            break

    if tmp_user_h >= 1:
        end = mid
    else:
        start = mid + 1
print(end)