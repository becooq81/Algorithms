x = int(input())

n = 1
s = 0

while s < x:
    s += n
    n += 1
edge = n-1
#print("edge",edge)
#print("s", s)

nth = 0


ans_num = 0
ans_denom = 0
if edge % 2 == 0:
    num = 1
    denom = edge
    
    while nth < x - (s-edge) -1:
        num += 1
        denom -=1
        nth += 1
    ans_num = num
    ans_denom = denom
else:
    num = edge
    denom = 1
    while nth < x - (s-edge) -1:
        num -= 1
        denom += 1
        nth += 1
    ans_num = num
    ans_denom = denom

print(f"{ans_num}/{ans_denom}")