n = int(input())
m = list(map(int, input().split()))
dp = [1] * n

# 앞쪽의 값이 항상 뒤보다 커야함.
# 병사 수를 최대로 맞춰야함.

for i in range(n):
    for j in range(i):
        if m[i] < m[j]:
            dp[i] = max(dp[i] , dp[j]+1)

print(len(dp) - max(dp))
