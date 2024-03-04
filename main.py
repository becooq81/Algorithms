a, b, v = map(int, input().split())

distance = v - a
days = distance // (a-b) + 1
if a == v:
    print(1)
else:
    if (distance <= (a-b)): 
        days += 1
    if ((a-b)*(days-1)+a < v):
        days += 1

    print(days)
