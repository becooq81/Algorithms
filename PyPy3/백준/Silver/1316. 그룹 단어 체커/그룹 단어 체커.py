n = int(input())
words = []
for i in range(n):
   words.append(input())

group_count = 0
for word in words:
    letters = [word[0]]
    is_group = True
    for i in range(1, len(word)):
        if word[i] != word[i-1]:
            if word[i] in letters:
                is_group = False
                break
            else:
                letters.append(word[i])
    if is_group:
        group_count += 1
print(group_count)