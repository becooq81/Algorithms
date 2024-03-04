a, b, v = map(int, input().split())

distance = 0
if (v % a != 0):
    distance = a * (v // a) 
else:
    distance = v // a - a

quo = distance // (a-b)
if (distance % (a-b) != 0):
    quo += 1
print(quo + 1)