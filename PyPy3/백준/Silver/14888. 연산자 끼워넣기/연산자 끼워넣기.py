n = int(input())
nums = list(map(int, input().split()))
ops = list(map(int, input().split()))
# plus, minus, mult, div

tmp = []
ans = nums[0]
idx = 0

def dfs():
    global idx, ans
    if sum(ops) == 0:
        tmp.append(ans)
        return
        
    for i in range(4):
        if ops[i] >= 1:
            tmpc = ans
            ops[i] -=1
            idx += 1
            if i == 0:
                ans += nums[idx]
            elif i == 1:
                ans -= nums[idx]
            elif i == 2:
                ans *= nums[idx]
            elif i == 3:
                if ans < 0:
                    ans = -ans
                    ans //= nums[idx]
                    ans = -ans
                else: 
                    ans //= nums[idx]
            dfs()
            ops[i] += 1
            idx -= 1
            ans = tmpc
dfs()
print(max(tmp))
print(min(tmp))