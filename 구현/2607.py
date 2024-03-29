#비슷한 단어
n = int(input())
word_list = [input().strip() for _ in range(n)]

target = word_list[0]
compare = word_list[1:]
result = 0

for base in compare:
    if abs(len(base) - len(target)) or len(set(target).difference(set(base))) > 1:      # 문자열 길이 or 구성하는 문자 차이나면 안됨.
        continue
    for t in target:
        if t in base:
            base = base.replace(t, "", 1)
    if len(base) <= 1:
        result += 1

print(result)
