# 6083 : [기초-종합] 빛 섞어 색 만들기
r, g, b = map(int, input().split())
temp = 0

for i in range(r):
    for j in range(g):
        for h in range(b):
            temp += 1
            print(i, j, h)

print(temp)