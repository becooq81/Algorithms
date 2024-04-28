import sys

n = int(sys.stdin.readline())

for i in range(1, 10):
    print(str(n)+" * "+str(i)+" = "+str(n*i))