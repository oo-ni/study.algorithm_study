# 6097 : [기초-리스트] 설탕과자 뽑기
h, w = map(int, input().split())
location = [[0 for j in range(w)] for i in range(h)]

n = int(input())
for i in range(n):
    l, d, x, y = map(int, input().split())
    for j in range(l):
        if d == 0:
            location[x-1][y-1+j] = 1
        else:
            location[x-1+j][y-1] = 1

for i in range(h):
    for j in range(w):
        print(location[i][j], end=' ')
    print()
