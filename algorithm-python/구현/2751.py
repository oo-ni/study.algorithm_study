# 2750 이랑 같지만, 메모리 제한이 생기는 문제. 
# sys.stdin.readline 활용하여 해결

import sys
input = sys.stdin.readline

n = int(input())
list = sorted([int(input()) for i in range(n)])

for i in range(n):
    print(list[i])