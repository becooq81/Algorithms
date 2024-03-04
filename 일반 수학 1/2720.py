t = int(input())
changes = []
for _ in range(t):
    changes.append(int(input()))

ans = []
for change in changes:
    quarter_count = change // 25
    change %= 25
    
    dime_count = change // 10
    change %= 10
    
    nickel_count = change // 5
    change %= 5
    
    penny_count = change // 1
    ans.append([quarter_count, dime_count, nickel_count, penny_count])
    
for row in ans:
    print(*row)