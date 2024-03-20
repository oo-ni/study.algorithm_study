# ATM

n = int(input())
p = list(map(int, input().split()))
temp = 0 
result = 0
p.sort()

for i in range(n):
    temp += p[i]
    result += temp

print(result)