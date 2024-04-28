import sys
t = int(sys.stdin.readline())
for _ in range(t):
    parantheses = sys.stdin.readline()
    
    queue = []
    ans = "YES"
    for par in parantheses:
        if par == "(":
            queue.append("(")
        elif par == ")":
            if not queue:
                ans = "NO"
                break
            else:
                queue.pop()
    if queue:
        ans = "NO"
    print(ans)