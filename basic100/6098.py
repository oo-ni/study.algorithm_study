# 6098 : [기초-리스트] 성실한 개미
maze = [list(map(int, input().split())) for _ in range(10)]

x, y = 1, 1

while True:
    # 이동 가능한 경우
    if (maze[x][y] == 0):
        maze[x][y] = 9
    elif (maze[x][y] == 2):
        maze[x][y] = 9
        break

    # 이동 불가능한 경우
    if ((maze[x][y+1] == 1 and maze[x+1][y] == 1)):
        break

    # 벽을 만났을 경우
    if (maze[x][y+1] != 1):
        y += 1
    elif (maze[x+1][y] != 1):
        x +=  1

for i in range(10):
    for j in range(10):
        print(maze[i][j], end=' ')
    print()
