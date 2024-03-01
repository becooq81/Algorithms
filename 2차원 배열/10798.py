words = []
for _ in range(5):
    word = input()
    words.append([word[i] if i < len(word) else '' for i in range(15)])
printed = ""
for i in range(15):
    for j in range(5):
        printed += words[j][i]
print(printed)