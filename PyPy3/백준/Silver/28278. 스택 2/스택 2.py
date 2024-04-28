import sys

queue = []

def take_action(instr, val=None):
    if instr == 1:
        queue.append(val)
    elif instr == 2:
        if len(queue) != 0:
            print(queue.pop())
        else:
            print(-1)
    elif instr == 3:
        print(len(queue))
    elif instr == 4:
        if queue:
            print(0)
        else:
            print(1)
    elif instr == 5:
        if queue:
            ans = -1
            for i in range(len(queue)-1,-1,-1):
                if int(queue[i]) == queue[i]:
                    ans = int(queue[i])
                    break
            print(ans)
        else:
            print(-1)
    
n = int(input())
for _ in range(n):
    input_text = sys.stdin.readline()
    if len(input_text) > 2:
        instr, val = map(int, input_text.split())
        take_action(instr, val)
    else:
        take_action(int(input_text))