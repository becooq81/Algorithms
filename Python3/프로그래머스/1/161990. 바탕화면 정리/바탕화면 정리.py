def solution(wallpaper):
    x = []
    y = []
    for row in range(len(wallpaper)):
        for col in range(len(wallpaper[row])):
            if wallpaper[row][col]=="#":
                x.append(col)
                y.append(row)
                print(row, ", ", col)
    min_x, min_y = min(x), min(y)
    print("before: x list ", x)
    print("before: y list ", y)
    x.append(max(x)+1)
    y.append(max(y)+1)
    print("after: x list", x)
    print("y list ", y)
    max_x, max_y = max(x), max(y)
    print(min_y, min_x, max_y, max_x)
    answer = [min_y, min_x, max_y, max_x]
    return answer