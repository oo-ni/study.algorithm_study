n, k = map(int, input().split())
coin = [int(input()) for i in range(n)]
result = 0

for i in range(n-1, -1, -1):
    if k < coin[i]:
        continue
    else:
        result += (k//coin[i])
        k = k%coin[i]

print(result)