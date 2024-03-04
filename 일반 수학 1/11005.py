n, b = map(int, input().split())
answer = ''
characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

while n:
    answer += str(characters[n % b]) 
    n //= b

print(answer[::-1]) 