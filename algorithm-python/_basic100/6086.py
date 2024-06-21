# 6086 : [기초-종합] 거기까지! 이제 그만~
n = int(input())
temp = 0
result = 0

while True:
    temp += 1
    result += temp
    if result >= n:
        break
print(result)