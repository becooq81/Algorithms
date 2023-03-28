import math


def primes(M, N):
    for i in range(M, N+1):
        if (i == 1):
            continue
        isPrime = True
        for j in range(2, int(math.sqrt(i))+1):
            if (i % j == 0):
                isPrime = False
                break
        if (isPrime):
            print(i)


M, N = map(int, input().split())
primes(M, N)