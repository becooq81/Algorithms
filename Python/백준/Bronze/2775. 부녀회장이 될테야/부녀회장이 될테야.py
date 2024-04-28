def func():
    residents = 0
    k = int(input())
    n = int(input())
    zero = [x for x in range(1, n + 1)]

    for i in range(k):
        for j in range(1, n):
            zero[j] += zero[j-1]

    print(zero[-1])

def repeat(n):
    for i in range(n):
        func();

repeat(int(input()))