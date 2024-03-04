n, m = map(int, input().split())

squares = []
for _ in range(n):
    squares.append(input())

min_change = 64
for i in range(n+1-8):
    for j in range(m+1-8):
        chess = []
        for idx in range(8):
            chess.append(squares[i+idx][j:j+8])
        
        first_is_white = False
        is_white = first_is_white
        count = 0
        for k in range(len(chess)):
            for l in range(len(chess)):
                if l == 0:
                    if first_is_white:
                        if k % 2 == 0:
                            if chess[k][l] == "B":
                                count += 1
                            is_white = True
                        else:
                            if chess[k][l] == "W":
                                count += 1
                            is_white = False
                    else:
                        if k % 2 == 0:
                            if chess[k][l] == "W":
                                count += 1
                            is_white = False
                        else:
                            if chess[k][l] == "B":
                                count += 1
                            is_white = True
                elif is_white and chess[k][l] == "B":
                    count += 1
                elif (not is_white) and chess[k][l] == "W":
                    count += 1
                is_white = not is_white
        if count < min_change:
            min_change = count
        
        first_is_white = True
        is_white = first_is_white
        count = 0
        for k in range(len(chess)):
            for l in range(len(chess)):
                if l == 0:
                    if first_is_white:
                        if k % 2 == 0:
                            if chess[k][l] == "B":
                                count += 1
                            is_white = True
                        else:
                            if chess[k][l] == "W":
                                count += 1
                            is_white = False
                    else:
                        if k % 2 == 0:
                            if chess[k][l] == "W":
                                count += 1
                            is_white = False
                        else:
                            if chess[k][l] == "B":
                                count += 1
                            is_white = True
                elif is_white and chess[k][l] == "B":
                    count += 1
                elif (not is_white) and chess[k][l] == "W":
                    count += 1
                is_white = not is_white
        if count < min_change:
            min_change = count
        
        
        

print(min_change)    
