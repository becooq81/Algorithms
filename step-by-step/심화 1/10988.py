word = input().strip()
length = len(word)
is_palindrome = True

for i in range(0, length//2):
    if (word[i] != word[length-i-1]):
        is_palindrome = False
        break
print(1 if is_palindrome else 0)