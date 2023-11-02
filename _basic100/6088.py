# 6088 : [기초-종합] 수 나열하기1
a, d, n = map(int, input().split())

for i in range(n-1):
    a += d

print(a)