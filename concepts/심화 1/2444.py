n = int(input())
for (i, j) in zip(range(n-1, -1, -1), range(1, n+1)):
    print(' '*i + '*'*(2*j-1))
for (i, j) in zip(range(1, n), range(n-1, 0, -1)):
    print(' '*i + '*'*(2*j-1))