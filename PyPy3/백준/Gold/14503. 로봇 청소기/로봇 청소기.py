n, m = map(int, input().split())
r, c, d = map(int, input().split())
coordinates = []
for _ in range(n):
    coordinates.append(list(map(int, input().split())))


moves = [(-1, 0), (0, 1), (1, 0), (0, -1)]

def dfs(x, y, dir_idx, count):
    if coordinates[x][y] == 0:
        coordinates[x][y] = 2
        count += 1

    for i in range(4):
        dir_idx = (dir_idx + 3) % 4
        move_x, move_y = moves[dir_idx]
        nx, ny = x + move_x, y + move_y

        if 0 <= nx < n and 0 <= ny < m and coordinates[nx][ny] == 0:
            count = dfs(nx, ny, dir_idx, count)
            return count

    back_dir_idx = (dir_idx + 2) % 4
    back_move_x, back_move_y = moves[back_dir_idx]
    back_x, back_y = x + back_move_x, y + back_move_y

    if 0 <= back_x < n and 0 <= back_y < m and coordinates[back_x][back_y] != 1:
        count = dfs(back_x, back_y, dir_idx, count)

    return count

count = dfs(r, c, d, 0)
print(count)
