import sys

t = int(sys.stdin.readline())
testcases = []
for _ in range(t):
    testcases.append(int(sys.stdin.readline()))
for testcase in testcases:
    zeros = 0
    ones = 0
    
    pairs = [[1,0],[0,1]]
    for num in range(2, testcase +1):
        pairs.append([pairs[num-2][0]+pairs[num-1][0], pairs[num-1][1]+pairs[num-2][1]])
        
    print(f"{pairs[testcase][0]} {pairs[testcase][1]}")