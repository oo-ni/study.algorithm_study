# 수열
import sys
from tkinter import N
input = sys.stdin.readline

N = int(input())
data = list(map(int, input().split()))

dp1 = [1]*N
dp2 = [1]*N

for i in range(N-1):
    if data[i+1] >= data[i]:
        dp1[i+1] += dp1[i]

for i in range(N-1):
    if data[i+1] >= data[i]:
        dp2[i+1] += dp2[i]

max1 = max(dp1)
max2 = max(dp2)

print(max(max1, max2))