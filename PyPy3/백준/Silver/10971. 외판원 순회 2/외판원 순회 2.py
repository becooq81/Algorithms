n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]


visited = [1] * n
ans = 1e10
tmp = 0
def dfs(start, initial, prev):
    global tmp, ans
    if sum(visited) == 0 and graph[prev][initial] > 0:
        #print("start: ", start, "initial", initial)
        tmp += graph[start][initial]
        ans = min(ans, tmp)
        #print("Success", tmp, "ans is", ans)
        tmp -= graph[start][initial]
        return
    for i in range(n):
        if visited[i] > 0 and graph[start][i] > 0:
            visited[i] -= 1
            tmp += graph[start][i]
            #print("Exploring", i, "from ", start)
            #print("  Now distance is", tmp)
            #print("  Visited: ", *visited)
            dfs(i, initial, start)
            tmp -= graph[start][i]
            visited[i] += 1
            #print("Backtracking", i)
            #print("  Now distance is", tmp)
            #print("  Visited: ", *visited)
            
    
dfs(0, 0, 0)

print(ans)