# 6077 : [기초-종합] 짝수 합 구하기
n = int(input())
result = 0

for i in range(1, n+1):
    if i % 2 == 0:
        result += i
    
print(result)