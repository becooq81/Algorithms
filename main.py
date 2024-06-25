t = int(input())
for _ in range(t):
    n = int(input())
    prices = list(map(int, input().split))
    max_profits = []
    
    max_price = max(prices)
    