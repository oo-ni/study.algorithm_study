# 6093 : [기초-리스트] 이상한 출석 번호 부르기2
# 개념 활용 : range(시작, 끝, 증감) #시작 수는 포함, 끝 수는 포함하지 않음.
n = int(input())
a = input().split()

for i in range(n-1, -1, -1):
    print(a[i], end=' ')
