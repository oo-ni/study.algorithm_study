# 6074 : [기초-반복실행구조] 문자 1개 입력받아 알파벳 출력하기
word = ord(input()) # ord(ordinal position) - 문자의 순성 위치 값을 의미하며, 10진수로 값을 변환해줌.

start = ord('a')
while start <= word:
    print(chr(start), end='')
    start += 1