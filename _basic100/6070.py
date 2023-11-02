# 6070 : [기초-조건/선택실행구조] 월 입력받아 계절 출력하기
month = int(input())
winter = [12,1,2]
spring = [3,4,5]
summer = [6,7,8]
fall = [9,10,11]

if month in winter:
    print("winter")
elif month in spring:
    print("spring")
elif month in summer:
    print("summer")
else:
    print("fall")