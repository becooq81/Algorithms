from collections import deque
import sys

nums = deque()
def take_action(instr, val=None):
    if instr == 1:
        nums.appendleft(val)
    elif instr == 2:
        nums.append(val)
    elif instr == 3:
        if nums:
            print(nums.popleft())
        else:
            print(-1)
    elif instr == 4:
        if nums:
            print(nums.pop())
        else:
            print(-1)
    elif instr == 5:
        print(len(nums))
    elif instr == 6:
        if nums:
            print(0)
        else:
            print(1)
    elif instr == 7:
        if nums:
            print(nums[0])
        else:
            print(-1)
    elif instr == 8:
        if nums:
            print(nums[-1])
        else:
            print(-1)
        

n = int(sys.stdin.readline())
for _ in range(n):
    input_text = sys.stdin.readline()
    if len(input_text) > 2:
        instr, val = map(int, input_text.split())
        take_action(instr, val)
    else:
        take_action(int(input_text))