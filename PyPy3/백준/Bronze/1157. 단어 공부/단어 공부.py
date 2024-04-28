word = input().lower()
letter_counts = {}
max_frequency = 0
most_frequent = []

for letter in word:
    if letter in letter_counts:
        letter_counts[letter] += 1
    else:
        letter_counts[letter] = 0
        
    if letter_counts[letter] > max_frequency:
        max_frequency = letter_counts[letter]
        most_frequent = [letter]
    elif letter_counts[letter] == max_frequency:
        most_frequent.append(letter)

print(most_frequent[0].capitalize() if len(most_frequent) == 1 else "?")