# 두 배열의 각 원소의 곱을 합친 값이 최소가 되도록 하는 문제.
# 한 배열의 가장 큰 수와 나머지 배열의 가장 작은 수에 대한 연산을 수행하면 최소값 얻기 가능.
# 하나는 오름차순, 하나는 내림차순으로 정렬 후 연산 수행.

n = int(input())
A = sorted(list(map(int, input().split())))
B = sorted(list(map(int, input().split())), reverse=True)

result = 0

for i in range(n):
    result += A[i]*B[i]

print(result)