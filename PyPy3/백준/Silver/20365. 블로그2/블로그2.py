n = int(input())
pattern = input()


c = 0
c1 = 0
c2 = 0
first = pattern[0]
for i in range(n-1):
    if pattern[i] == first and pattern[i+1] != first:
        c1 += 1

print(c1+1)