# 뒤집기
import math

N = str(input())
temp = 0

# 문자열이 바뀌는 경우 temp에 저장.
for i in range(1, len(N)):
    if N[i-1] != N[i]:
        temp += 1

result = math.ceil(temp/2)  # 한 번만 바뀌는 경우를 위해 올림(ceil)추가, 값 계산을 위해 2로 나눠줌.

print(result)