a, b, c = map(int, input().split())

set = [a, b, c]
longest = max(set)
set.remove(longest)
if sum(set) <= longest:
    print(sum(set) + sum(set)-1)
else:
    print(sum(set) +longest)