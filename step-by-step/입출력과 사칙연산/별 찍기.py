
n = int(input())
for i in range(n):
    str = ""
    str += " " * i
    str += "*" * (n-i)
    print(str)
