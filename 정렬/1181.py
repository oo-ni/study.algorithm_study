n = int(input())
WORD = []

for _ in range(n):
    w = input()
    WORD.append(w)

result = list(set(WORD))
result.sort()
result.sort(key=len)

for i in range(len(result)):
    print(result[i])