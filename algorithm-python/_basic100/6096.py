# 6096 : [기초-리스트] 바둑알 십자 뒤집기
'''
십자 뒤집기는 
그 위치에 있는 모든 가로줄 돌의 색을 반대(1->0, 0->1)로 바꾼 후, 다시 그 위치에 있는 모든 세로줄 돌의 색을 반대로 바꾸는 것이다.
어떤 위치를 골라 십자 뒤집기를 하면, 그 위치를 제외한 가로줄과 세로줄의 색이 모두 반대로 바뀐다.
'''
d = [list(map(int, input().split())) for _ in range(19)]

n = int(input())

for i in range(n):
    x, y = map(int, input().split())
    for j in range(19):
        if d[j][y-1]==0:
            d[j][y-1]=1
        else :
            d[j][y-1]=0

        if d[x-1][j]==0:
            d[x-1][j]=1
        else :
            d[x-1][j]=0

for i in range(19):
    for j in range(19):
        print(d[i][j], end=' ')
    print()