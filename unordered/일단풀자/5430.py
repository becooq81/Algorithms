import sys
from collections import deque
input = sys.stdin.readline

t = int(input())
for i in range(t):
    p = input()
    n = int(input())
    arr = input()
    deq = deque() if n==0 else deque(arr.strip("[]\n").split(","))

    br = False
    reverse_count = 0
    for j in p:
        if j == "D":
            if len(deq) == 0:
                br = True
                print("error")
                break
            elif reverse_count % 2 == 0:
                deq.popleft()
            else:
                deq.pop()
        elif j == "R":
            reverse_count += 1
    if reverse_count % 2 == 1:
        deq.reverse()
    if not br:
        print("[" + ",".join(deq) + "]")