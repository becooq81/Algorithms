n, m = map(int, input().split())
ans = []
def dfs():
    if len(ans) == m:
        print(' '.join(map(str, ans)))
        return
    for i in range(1, n+1):
        if i not in ans and (len(ans) == 0 or i > ans[-1]):
            ans.append(i)
            dfs()
            ans.pop()
dfs()