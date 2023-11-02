# 6092 : [기초-리스트] 이상한 출석 번호 부르기1
n = int(input())    # 개수를 입력
a = input().split() # 공백 기준으로 잘라 입력

for i in range(n):
    a[i] = int(a[i])    # a의 인덱스들을 정수로 변환하여 인덱스화

d = []  # 리스트 생성
for i in range(24):
    d.append(0) # 기본값 0으로 23개의 원소를 가진 리스트 생성

for i in range(n):
    d[a[i]] += 1    # d 배열의 a[i]번 인덱스에 해당하는 원소들에 1씩 추가.

for i in range(1, 24):
    print(d[i], end=' ')
