n = int(input())
dp = []

for i in range(n):
    dp.append(list(map(int, input().split())))  # 이차원 배열

for i in range(1, n):   # 행 기준으로 n-1번의 연산
    for j in range(i+1):    # j는 n만큼의 연산을 수행
        if j == 0:
            dp[i][0] += dp[i-1][0]
        elif j == i:
            dp[i][j] += dp[i-1][j-1]
        else:
            dp[i][j] += max(dp[i-1][j-1], dp[i-1][j])

print(max(dp[n-1]))