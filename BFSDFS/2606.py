n, m = map(int, input().split('/n'))

graph = [[0]*(n+1) for _ in range(n+1)]
for i in range (m):
    a, b = map(int,input().split())
    graph[a][b] = graph[b][a] = 1


