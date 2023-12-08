import sys
from collections import deque

def bfs(x):
    q = deque([x])
    while q:
        x = q.popleft()
        if x == k:
            return dist[x]
        for nx in (x-1, x+1, x*2):
            if 0 <= nx <= MAX and not dist[nx]:
                dist[nx] = dist[x] + 1
                q.append(nx)    

n, k = map(int, sys.stdin.readline().split())
MAX = 10 ** 5
dist = [0] * (MAX)

print(bfs(n))