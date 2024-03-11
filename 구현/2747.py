# 피보나치 수열을 구현하는 문제
# 그냥 품
n = int(input())
fib = []
        
for i in range(n+1):
    if i >= 2 :
        fib.append(fib[i-1] + fib[i-2])
    else:
        fib.append(i)

print(fib[n])