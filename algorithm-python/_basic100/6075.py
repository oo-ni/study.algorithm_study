# 6075 : [기초-반복실행구조] 정수 1개 입력받아 그 수까지 출력하기1
n = int(input())
start = -1

while start < n:
    start += 1
    print(start)
    if start == n:
        break