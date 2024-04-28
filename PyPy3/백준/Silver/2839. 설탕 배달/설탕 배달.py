n = int(input())

five_count = n // 5
three_count = (n - five_count * 5) // 3
ans = -1
while five_count >= 0:
    if five_count * 5 + three_count * 3 == n:
        ans = five_count +three_count
        break
    five_count -= 1
    three_count = (n - five_count * 5) // 3
print(ans)