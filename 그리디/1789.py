s = int(input())
temp = 1
n = 1

while True:
    if (n <= s):
        temp += 1
        n += temp
    else:
        break

print(temp-1)