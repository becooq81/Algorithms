import sys

t = int(sys.stdin.readline())
testcases = []
for _ in range(t):
    testcases.append(int(sys.stdin.readline()))
for testcase in testcases:
    zeros = 0
    ones = 0
    if testcase == 0:
        zeros = 1
        ones = 0
    elif testcase == 1:
        zeros = 0
        ones = 1
    else:
        print(f"{zeros} {ones}")