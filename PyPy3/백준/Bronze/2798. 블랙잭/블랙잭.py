n, m = map(int, input().split())
cards = list(map(int, input().split()))

diff = 300000

sum=0
for i in range(n-2):
    for j in range(i+1,n-1):
        for k in range(j+1,n):
            s = cards[i] + cards[j] + cards[k]
            if m-s >= 0 and m - s <= diff:
                sum = s
                diff = m-s
print(sum)
