# 6090 : [기초-종합] 수 나열하기3
a, m, d, n = map(int, input().split())

for i in range(n-1):
    a *= m
    a += d

print(a)