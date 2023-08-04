s = input()
num = 0
text = []

for i in s:
    if i.isdigit():
        num += int(i)
    else:
        text.append(i)

text.sort()

if num >= 0:
    text.append(str(num))

print(''.join(text))


'''
Q8_문자열 재정렬

- 문제풀이 핵심 아이디어
숫자인 경우 합계를 계산
문자인 경우 리스트에 저장 후 정렬
isdigit() 문자열 메서드를 사용

- 시간복잡도
문자열의 길이 n에 따라 O(n)의 시간복잡도를 가짐.
'''