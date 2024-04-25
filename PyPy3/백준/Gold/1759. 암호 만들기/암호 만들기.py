l, c = map(int, input().split())
lets = list(input().split())
lets.sort()
route = []
vct = 0
ccnt = 0
vowels = {"a", "e", "i", "o", "u"}
def dfs(start):
    global vct, ccnt
    if len(route) == l and vct >= 1 and ccnt >= 2:
        print(''.join(map(str, route)))
    for i in range(start, len(lets)):
        route.append(lets[i])
        if lets[i] in vowels:
            vct += 1
        else:
            ccnt += 1
        dfs(i+1)
        if lets[i] in vowels:
            vct -= 1
        else:
            ccnt -= 1
        route.pop()
dfs(0)