n = list(map(int, input().split()))
result = 0

for i in range(10):
    if n[i]%2 != 0:
        result += n[i]
     
print("#", result)