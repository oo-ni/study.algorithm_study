n = input()
result = [0]*10

for i in n:         # 각 문자열 직접 순회
    # 6 또는 9일 경우 처리 - 둘 중 적게 나온 수의 값을 처리해야 함.
    # 6이 이미 나온 경우 9의 카운트를 늘려야 함.
    if i == '6' or i == '9':
        if result[6] <= result[9]:
            result[6] += 1
        else:
            result[9] += 1
    else:
        result[int(i)] += 1

print(max(result))