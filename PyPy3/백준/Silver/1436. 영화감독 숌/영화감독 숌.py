n = int(input())
count = 1
ans = 666
while count < n:
   ans += 1
   if "666" in str(ans):
       count += 1
print(ans)