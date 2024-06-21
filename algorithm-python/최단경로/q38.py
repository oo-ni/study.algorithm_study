n, m = map(int, input().split()) # 학생들의 수 n, 두 학생의 성적을 비교한 횟수 m
INF = int(1e9)
graph = [[INF] * (n + 1) for _ in range(n + 1)] # 모든 간선을 무한으로 초기화
    
for a in range(1, n + 1) : # 자기 자신으로 향하는 건 0으로 초기화
    for b in range(1, n + 1) :
        if a == b :
            graph[a][b] = 0

for _ in range(m): # i 성적 < j 성적
    i, j = map(int, input().split())
    graph[i][j] = 1
            
# 플로이드 와샬 알고리즘
for k in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])
            
ans = 0 # 출력할 결과
for i in range(1, n + 1):
    ct = 0 # 비교할 결과
    for j in range(1, n + 1):
        if graph[i][j] != INF or graph[j][i] != INF: # 성적 비교가 가능하다면
            ct += 1
    if ct == n: # 총 비교할 수 있는 수 == 총 학생 수
        ans += 1
            
print(ans)