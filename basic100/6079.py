# 6079 : [기초-종합] 언제까지 더해야 할까?
n = int(input())
a = 0
b = 0

while b < n:
    a += 1
    b += a

print(a)