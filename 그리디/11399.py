# ATM

N = int(input())
P = list(map(int, input().split()))

P.sort()
temp = 0
result = 0

for i in range(N):
    temp += P[i]
    result += temp

print(result)