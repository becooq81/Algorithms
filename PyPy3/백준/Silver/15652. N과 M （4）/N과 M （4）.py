n, m = map(int, input().split())
ans = []
def dfs():
    if len(ans) == m:
        print(' '.join(map(str, ans)))
        return
    for i in range(1, n+1):
        if len(ans) == 0 or ans[-1]<=i:
            ans.append(i)
            dfs()
            ans.pop()
dfs()