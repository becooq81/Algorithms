def factorial(n):
    f = 1
    for i in range(1, int(n)+1):
        f *= i
    print(f)

factorial(input())
