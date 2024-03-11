# 수를 오름차순으로 정렬하는 문제
# sorted 쓸까말까

n = int(input())
list = sorted([int(input()) for i in range(n)])

for i in range(n):
    print(list[i])
