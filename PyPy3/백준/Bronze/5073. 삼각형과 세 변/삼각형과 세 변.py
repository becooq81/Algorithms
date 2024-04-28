triangles = []
while True:
    a, b, c = map(int, input().split())
    if a == 0 and b == 0 and c == 0:
        break
    triangles.append([a,b,c])
    
for x, y, z in triangles:
    set = [x, y, z]
    longest = max(set)
    set.remove(longest)    
    if sum(set) <= longest:
        print("Invalid")
    else:
        if x == y and y == z and x == z:
            print("Equilateral")
        elif x == y or x == z or y == z:
            print("Isosceles")
        else:
            print("Scalene")