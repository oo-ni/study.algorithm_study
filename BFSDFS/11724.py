# 연결 그래프 만들고 연결 요소의 개수 출력하는 문제.
# dfs나 bfs로 방문기록을 남기고, 이를 한 번 빠져나올때 마다 count 해주면 됨.

import sys
sys.setrecursionlimit(10**5)    # 백준 런타임 에러 방지용..
input = sys.stdin.readline

def dfs(v):
    visited[v] = True   # 방문 처리
    for i in graph[v]:
        if not visited[i]:
            dfs(i)

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]

for i in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

visited = [False] * (n+1)   # 방문 처리
count = 0   # 연결 노드의 수

for i in range(1, n+1):
    if not visited[i]:      # 만약 i번째 노드를 방문하지 않았다면
        count += 1          # count를 하나 늘려주고,
        dfs(i)              # 노드 기반 dfs를 돌림.

print(count)