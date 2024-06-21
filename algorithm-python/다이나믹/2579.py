n = int(input())
s = [0] * 301
for i in range(n):
    s[i] = int(input())

DP = [0] * 301
DP[0] = s[0]
DP[1] = s[0] + s[1]
DP[2] = max(s[0] + s[2], s[1] + s[2])

for i in range(3, n):
    DP[i] = max(DP[i-3] + s[i-1] + s[i], DP[i-2] + s[i])

print(DP[n-1])