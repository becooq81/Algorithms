word = input()
translation = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]
letter_count = 0

i = 0
while i <len(word):
    if i+2 < len(word) and word[i:i+3] in translation:
        i += 2
    elif i+1 < len(word) and word[i:i+2] in translation:
        i += 1
    letter_count += 1
    i += 1
print(letter_count)