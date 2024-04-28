def repeat(n):
    result = []
    for _ in range(int(n)):
        result.append(func())
    for _ in range(int(n)):
        print(result[_])

def func():
    height, width, guest = map(int, input().split())
    X = guest // height
    if (height >= guest):
        Y = guest
    if (guest % height == 0):
        Y = height
    else:
        Y = guest % height
        X += 1

    return (Y*100 + X)

repeat(input())