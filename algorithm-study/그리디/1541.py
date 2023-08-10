exp = input() 
n = exp.split('-')   # 뺄셈기호 기준으로 문자열 나누기

ans = 0

for i in n[0].split('+'):
    ans += int(i)   # 00009와 같은 경우로 인해 정수화

for i in n[1:]:
  for j in i.split('+'):
    ans -= int(j)

print(ans)


'''
1541_잃어버린 괄호

- 문제풀이 핵심 아이디어
최초로 마이너스가 나오기 전까지 숫자는 모두 더하고,
이후 마이너스가 나오는 경우 그 뒤의 수들을 모두 뺌.

- 시간복잡도
split된 n개의 숫자에 대한 연산을 실행했기에 O(n)의 시간복잡도를 가짐.
'''